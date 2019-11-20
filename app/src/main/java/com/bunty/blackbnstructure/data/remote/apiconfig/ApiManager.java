package com.bunty.blackbnstructure.data.remote.apiconfig;

import com.bunty.blackbnstructure.utils.AppConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static ApiService mApiService;
    private static Retrofit mRetrofit;

    private ApiManager() { }

    public static ApiService getApiClient() {

        if (mApiService == null) {

            mRetrofit = new Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mApiService = mRetrofit.create(ApiService.class);
        }

        return mApiService;
    }
}
