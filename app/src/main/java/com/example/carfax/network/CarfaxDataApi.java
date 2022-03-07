package com.example.carfax.network;

import com.example.carfax.models.Cars;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CarfaxDataApi {

    @GET("/assignment.json")
    Call<Cars.Example> getCars();

    @GET("/assignment.json")
    Call<Cars.Example.Listing> getCarList();
}
