package com.example.carfax;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.carfax.models.Cars;

import java.util.List;

@Dao
public interface CarDao {

    @Query("SELECT * FROM example_table")
    List<Cars.Example> getAllCars();

    @Query("SELECT * FROM listing_table")
    List<Cars.Example.Listing> getCarListing();

    @Query("SELECT * FROM dealer_table")
    List<Cars.Example.Listing.Dealer> getDealerInfo();

    @Query("SELECT * FROM image_table")
    List<Cars.Example.Listing.Images> getImages();

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

