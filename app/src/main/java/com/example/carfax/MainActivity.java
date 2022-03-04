package com.example.carfax;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.car_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CarAdapter(MainActivity.this, carsList, this);
        recyclerView.setAdapter(adapter);
        carDatabase = CarDatabase.getInstance(getApplicationContext());
        getCars();

    }

    public void getCars() {
        CarfaxDataApi carfaxDataApi = RetrofitClient.getCarfaxDataApi();
        Call<Cars.Example> call = carfaxDataApi.getCars();

        call.enqueue(new Callback<Cars.Example>() {
            @Override
            public void onResponse(Call<Cars.Example> call, Response<Cars.Example> response) {
                Cars.Example carData = response.body();
                carsList = carData.getListings();
                if (carsList != null) {
                    adapter.setCars(carsList);
                }
                recyclerView.setAdapter(adapter);
                storeOffline(carData);
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
                carDatabase.carDao().insertCarList(bulkCars.getListings());
                //carDatabase.carDao().insertDealer(carsList);
                for (int i = 0; i < carsList.size(); i++) {
                    carDatabase.carDao().insertExampleData(bulkCars);
                    carDatabase.carDao().insertDealer(bulkCars.getListings().get(i).getDealer());
                    carDatabase.carDao().insertImageTable(bulkCars.getListings().get(i).getImages());
                    carDatabase.carDao().insertFirstPhoto(bulkCars.getListings().get(i).getImages().getFirstPhoto());
                }
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