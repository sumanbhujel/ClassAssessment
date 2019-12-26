package com.example.classassessment.api;

import com.example.classassessment.model.Flag;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface FlagInterface {

    @GET("flags")
    Call<List<Flag>> getFlags();

    @GET("singleflag/{id}")
    Call<Flag> getCountryById(@Path("id") int id);

    @Multipart
    @POST("upload")
    Call<Flag> uploadFlag(@Part MultipartBody.Part img);

    @FormUrlEncoded
    @POST("addcountry")
    Call<Void> adCountry(@Field("name") String name ,
                         @Field("country") String country);


}
