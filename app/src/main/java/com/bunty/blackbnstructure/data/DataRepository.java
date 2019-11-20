package com.bunty.blackbnstructure.data;

import android.content.SharedPreferences;

import com.bunty.blackbnstructure.data.local.AppDatabase;
import com.bunty.blackbnstructure.utils.AppExecutors;

public class DataRepository {

    private static volatile DataRepository INSTANCE = null;

    private final AppDatabase mDatabase;
    private final AppExecutors mAppExecutors;
    private final SharedPreferences mPreference;

    public static DataRepository getInstance(final AppDatabase database,
                                             final SharedPreferences preferences,
                                             final AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (DataRepository.class) {
                INSTANCE = new DataRepository(database, preferences, appExecutors);
            }
        }
        return INSTANCE;
    }

    private DataRepository(final AppDatabase database, final SharedPreferences preferences,
                           final AppExecutors appExecutors) {

        mDatabase = database;
        mPreference = preferences;
        mAppExecutors = appExecutors;
    }

}
