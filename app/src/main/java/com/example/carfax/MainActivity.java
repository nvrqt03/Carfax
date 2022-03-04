package com.example.carfax;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.carfax.models.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Parcelable;
import android.util.Log;
import android.widget.LinearLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements CarAdapter.OnCarListener {

    List<Cars.Example.Listing> carsList;
    String TAG = "MainActivity.class";
    RecyclerView recyclerView;
    CarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.car_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CarAdapter(MainActivity.this, carsList, this);
        recyclerView.setAdapter(adapter);
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
                Log.d(TAG, "onResponse: " + carData.getTotalListingCount());

                for (int i = 0; i < carsList.size(); i++) {
                    Log.d(TAG, "onResponse: " + carsList.get(i).getModel() + " " + carsList.get(i).getDealer().getCity());
                }
            }
            @Override
            public void onFailure(Call<Cars.Example> call, Throwable t) {

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