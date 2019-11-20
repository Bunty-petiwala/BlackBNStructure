package com.bunty.blackbnstructure.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.bunty.blackbnstructure.data.local.dao.UserInformationDao;
import com.bunty.blackbnstructure.data.model.UserInformation;

import static com.bunty.blackbnstructure.utils.AppConstants.DATABASE_NAME;

@Database(entities = {UserInformation.class},
        version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract UserInformationDao userInformationDao();


    public static AppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, DATABASE_NAME)
                        .build();
            }
        }
        return INSTANCE;
    }

}
