package com.example.carfax.network;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carfax.Constants;

import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient extends AppCompatActivity {

    private static CarfaxDataApi carfaxDataApi;

    public static CarfaxDataApi getCarfaxDataApi() {
        if (carfaxDataApi == null) {
            retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            carfaxDataApi = retrofit.create(CarfaxDataApi.class);
        }
        return carfaxDataApi;
    }
}
