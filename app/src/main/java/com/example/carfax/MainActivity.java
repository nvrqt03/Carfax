package com.example.carfax;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.example.carfax.models.Cars;

import java.util.List;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
    private static final int REQUEST_CALL = 1;

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
                    //List<Cars.Example.Listing> viewModelCarList = carViewModel.setCarList(carsList);
                    adapter.setCars(carViewModel.setCarList(carsList));
                    adapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY);
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
//    private void callDealer(String number) {
//        if (number.trim().length() > 0) {
//            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
//            } else {
//                String dial = "tel:" + number;
//                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
//            }
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == REQUEST_CALL) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                callDealer();
//            } else {
//                Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

}