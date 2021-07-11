package com.alamat.islami.Radio.Newtwork;

import com.alamat.islami.Radio.RadioModels.RadioResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APICalls {


    //api/radio/radio_ar.json
    @GET("radio/radio_ar.json")
    Call<RadioResponseModel>getRadio();

   // Call<RadioResponseModel> getAllSources(@Query("apiKey") String apiKey);
}


