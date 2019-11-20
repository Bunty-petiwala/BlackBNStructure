package com.bunty.blackbnstructure.data.remote.apiconfig;

import com.google.gson.JsonObject;
import com.bunty.blackbnstructure.data.model.UserInformation;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    @Multipart
    @POST("/addCriminal")
    Call<UserInformation> postImage(@Part MultipartBody.Part image,
                                    @Part("data") RequestBody body);

    @POST("/getCriminal")
    Call<UserInformation> postFaceEncoding(@Body JsonObject body);

}
