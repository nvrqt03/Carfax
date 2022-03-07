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

}

