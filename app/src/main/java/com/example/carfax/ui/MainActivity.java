package com.example.carfax.ui;



import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.carfax.network.AppExecutors;
import com.example.carfax.CarAdapter;
import com.example.carfax.CarDao;
import com.example.carfax.CarDatabase;
import com.example.carfax.network.CarfaxDataApi;
import com.example.carfax.R;
import com.example.carfax.network.RetrofitClient;
import com.example.carfax.models.Cars;

import java.util.List;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements CarAdapter.OnCarListener {

    private List<Cars.Example.Listing> carsList;
    String TAG = "MainActivity.class";
    private RecyclerView recyclerView;
    private CarAdapter adapter;
    private CarDao carDao;
    private CarDatabase carDatabase;
    private List<Cars.Example> offlineCarsList;
    private CarViewModel carViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carViewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(CarViewModel.class);

        recyclerView = findViewById(R.id.car_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CarAdapter(MainActivity.this, carViewModel.getCarsList(), this);
        adapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT);
        recyclerView.setAdapter(adapter);

        carDatabase = CarDatabase.getInstance(getApplicationContext());
        getCars();

        carViewModel.getAllCars().observe(this, new Observer<List<Cars.Example.Listing>>() {
            @Override
            public void onChanged(List<Cars.Example.Listing> listings) {
                for (int i = 0; i < listings.size(); i++) {
                    Log.d(TAG, "onChanged: make " + listings.get(i).getMake());
                }
            }
        });

        carViewModel.getDealers().observe(this, new Observer<List<Cars.Example.Listing.Dealer>>() {
            @Override
            public void onChanged(List<Cars.Example.Listing.Dealer> dealers) {

                for (int i = 0; i < dealers.size(); i++) {
                    Log.d(TAG, "onChanged: dealers " + dealers.get(i).getName());
                }
            }
        });
        carViewModel.getImages().observe(this, new Observer<List<Cars.Example.Listing.Images>>() {
            @Override
            public void onChanged(List<Cars.Example.Listing.Images> images) {
                for (int i = 0; i < images.size(); i++) {
                    Log.d(TAG, "onChanged: images " + images.get(i).getBaseUrl());
                }
            }
        });
        carViewModel.getPhotos().observe(this, new Observer<List<Cars.Example.Listing.Images.FirstPhoto>>() {
            @Override
            public void onChanged(List<Cars.Example.Listing.Images.FirstPhoto> images) {
                for (int i = 0; i < images.size(); i++) {
                    Log.d(TAG, "onChanged: first photos " + images.get(i).getLarge());
                }
            }
        });

    }

    public void getCars() {
        CarfaxDataApi carfaxDataApi = RetrofitClient.getCarfaxDataApi();
        Call<Cars.Example> call = carfaxDataApi.getCars();

        call.enqueue(new Callback<Cars.Example>() {
            @Override
            public void onResponse(Call<Cars.Example> call, Response<Cars.Example> response) {
                Cars.Example carData = response.body();
                // store response immediately to db
                storeOffline(carData);

                carsList = carData.getListings();
                // to make offline, instead of carlist being set to viewModel adapter, we'd need
                // to pull from the database instead of the network call.
                if (carsList != null) {
                    adapter.setCars(carViewModel.setCarList(carsList));
                    adapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY);
                }
                recyclerView.setAdapter(adapter);

            }
            @Override
            public void onFailure(Call<Cars.Example> call, Throwable t) {

            }
        });
    }

    public void storeOffline(Cars.Example bulkCars) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {

            @Override
            public void run() {
                carDatabase.carDao().insertCar(bulkCars);
//                carDatabase.carDao().insertCarList(bulkCars.getListings());
//                for (int i = 0; i < bulkCars.getListings().size(); i++) {
//                    carDatabase.carDao().insertExampleData(bulkCars);
//                    carDatabase.carDao().insertDealer(bulkCars.getListings().get(i).getDealer());
//                    carDatabase.carDao().insertImageTable(bulkCars.getListings().get(i).getImages());
//                    carDatabase.carDao().insertFirstPhoto(bulkCars.getListings().get(i).getImages().getFirstPhoto());
//                }
            }
        });
    }

    @Override
    public void onCarClick(Cars.Example.Listing car) {
        Intent intent = new Intent(this, CarDetailActivity.class);
        intent.putExtra("carDetails", car);
        intent.putExtra("dealerInfo", car.getDealer());
        intent.putExtra("image", car.getImages().getFirstPhoto());
        Log.d(TAG, "onCarClick: " + car.getExteriorColor() + car.getDealer().getCity());
        startActivity(intent);
    }

}
