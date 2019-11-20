package com.bunty.blackbnstructure.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.bunty.blackbnstructure.data.DataRepository;
import com.bunty.blackbnstructure.data.local.AppDatabase;
import com.bunty.blackbnstructure.utils.AppConstants;
import com.bunty.blackbnstructure.utils.AppExecutors;
import com.treebo.internetavailabilitychecker.InternetAvailabilityChecker;
import com.treebo.internetavailabilitychecker.InternetConnectivityListener;

public class BaseApp extends Application implements InternetConnectivityListener {

    private Boolean isInternetAvailable = false;
    private InternetAvailabilityChecker mInternetAvailabilityChecker;
    private AppExecutors mAppExecutors;

    //----------------------------------------------------------------------------------------------

    public BaseApp() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInternetAvailabilityChecker = InternetAvailabilityChecker.init(this);
        mInternetAvailabilityChecker.addInternetConnectivityListener(this);
        mAppExecutors = new AppExecutors();
    }

    //----------------------------------------------------------------------------------------------

    public Boolean isInternetAvailable() {
        return isInternetAvailable;
    }

    public AppExecutors getAppExecutors() {
        return mAppExecutors;
    }

    public SharedPreferences getPreferences() {
        return this.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE);
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this);
    }

    public DataRepository getRepository() {
        return DataRepository.getInstance(getDatabase(), getPreferences(), getAppExecutors());
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onInternetConnectivityChanged(boolean isConnected) {
        this.isInternetAvailable = isConnected;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mInternetAvailabilityChecker.removeAllInternetConnectivityChangeListeners();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        mInternetAvailabilityChecker.removeAllInternetConnectivityChangeListeners();
    }
}