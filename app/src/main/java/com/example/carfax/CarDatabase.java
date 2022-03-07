package com.example.carfax;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.carfax.models.Cars;

@Database(entities = {Cars.Example.class, Cars.Example.Listing.class, Cars.Example.Listing.Dealer.class,
        Cars.Example.Listing.Images.class, Cars.Example.Listing.Images.FirstPhoto.class}, version = 4, exportSchema = false)
public abstract class CarDatabase extends RoomDatabase {
    public static final String LOG_TAG = CarDatabase.class.getSimpleName();
    public static final Object LOCK = new Object();
    public static final String DATABASE_NAME = "carfax";
    private static CarDatabase sInstance;

    public static CarDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        CarDatabase.class, CarDatabase.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return sInstance;
    }

    public abstract CarDao carDao();
}
