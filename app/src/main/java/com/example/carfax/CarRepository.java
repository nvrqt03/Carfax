package com.example.carfax;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.carfax.models.Cars;

import java.util.List;

public class CarRepository {
    private CarDao carDao;
    private CarDatabase carDatabase;

    public CarRepository(Application application) {
        carDatabase = CarDatabase.getInstance(application);
        carDao = carDatabase.carDao();
    }

    public LiveData<List<Cars.Example.Listing>> getAllCars() {
        return carDao.getCarListing();
    }

    public LiveData<List<Cars.Example.Listing.Dealer>> getDealers() {
        return carDao.getDealerInfo();
    }
    public LiveData<List<Cars.Example.Listing.Images>> getImages() {
        return carDao.getImages();
    }

    public LiveData<List<Cars.Example.Listing.Images.FirstPhoto>> getPhotos() {
        return carDao.getFirstPhotos();
    }
}
