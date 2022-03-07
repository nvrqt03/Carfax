package com.example.carfax.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.carfax.CarDao;
import com.example.carfax.CarDatabase;
import com.example.carfax.CarRepository;
import com.example.carfax.models.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarViewModel extends AndroidViewModel {

    public List<Cars.Example.Listing> carsList; //feel like we should update this to livedata

    public LiveData<List<Cars.Example.Listing.Dealer>> dealers;
    public LiveData<List<Cars.Example.Listing>> allCars;
    public LiveData<List<Cars.Example.Listing.Images>> images;
    public LiveData<List<Cars.Example.Listing.Images.FirstPhoto>> photos;
//    public LiveData<List<Cars.Example>> allCarList;
    private CarDatabase carDatabase;
    private CarDao carDao;
    private CarRepository carRepository;

    public CarViewModel(@NonNull Application application) {
        super(application);
        carRepository = new CarRepository(application);
        //carDao = carDatabase.carDao();
        carsList = new ArrayList<>();

    }
    //allCars = carDao.getCarListing();
    //dealers = carDao.getDealerInfo();
    //images = carDao.getImages();
    //photos = carDao.getFirstPhotos();

    LiveData<List<Cars.Example.Listing>> getAllCars() {
        return carRepository.getAllCars();
        //return allCars;
    }

    LiveData<List<Cars.Example.Listing.Dealer>> getDealers() {
        return carRepository.getDealers();
    }
    LiveData<List<Cars.Example.Listing.Images>> getImages() {
        return carRepository.getImages();
    }

    LiveData<List<Cars.Example.Listing.Images.FirstPhoto>> getPhotos() {
        return carRepository.getPhotos();
    }

    public List<Cars.Example.Listing> setCarList(List<Cars.Example.Listing> carListings) {
        this.carsList = carListings;
        return carListings;
    }

    public List<Cars.Example.Listing> getCarsList() {
        return carsList;
    }
}
