package com.example.carfax;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.carfax.models.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarViewModel extends AndroidViewModel {

    public List<Cars.Example.Listing> carsList;

    public CarViewModel(@NonNull Application application) {
        super(application);
        carsList = new ArrayList<>();
    }

    public List<Cars.Example.Listing> setCarList(List<Cars.Example.Listing> carListings) {
        this.carsList = carListings;
        return carListings;
    }

    public List<Cars.Example.Listing> getCarsList() {
        return carsList;
    }
}
