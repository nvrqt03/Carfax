package com.example.carfax;

import static android.icu.text.MessagePattern.ArgType.SELECT;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.carfax.models.Cars;

import java.util.List;

@Dao
public interface CarDao {


    @Query("SELECT * FROM listing_table")
    LiveData<List<Cars.Example.Listing>> getCarListing();

    @Query("SELECT * FROM dealer_table")
    LiveData<List<Cars.Example.Listing.Dealer>> getDealerInfo();

    @Query("SELECT * FROM image_table")
    LiveData<List<Cars.Example.Listing.Images>> getImages();

    @Query("SELECT * FROM firstPhoto")
    LiveData<List<Cars.Example.Listing.Images.FirstPhoto>> getFirstPhotos();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCar(Cars.Example cars);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertCarList(List<Cars.Example.Listing> carListings);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertDealer(List<Cars.Example.Listing.Dealer> dealers);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertFirstPhoto(Cars.Example.Listing.Images.FirstPhoto firstPhotos);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertImageTable(Cars.Example.Listing.Images images);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertExampleData(Cars.Example carData);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDealer(Cars.Example.Listing.Dealer dealer);
}

