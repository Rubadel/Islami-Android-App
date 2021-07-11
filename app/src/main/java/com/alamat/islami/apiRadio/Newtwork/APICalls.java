package com.alamat.islami.apiRadio.Newtwork;

import com.alamat.islami.apiRadio.APImodels.RadioResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APICalls {


    //api/radio/radio_ar.json
    @GET("radio/radio_ar.json")
    Call<RadioResponseModel>getRadio();

   // Call<RadioResponseModel> getAllSources(@Query("apiKey") String apiKey);
}


