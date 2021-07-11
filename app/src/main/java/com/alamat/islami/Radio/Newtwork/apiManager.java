package com.alamat.islami.Radio.Newtwork;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiManager {

    private static Retrofit retrofit;

    private static Retrofit getInstance(){

        if(retrofit == null){
            //the server who respond
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(@NotNull String s) {
                    Log.e("retrofit",s);
                }
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            //the client who request
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();

            //then create retrofit that with requester and responder with the base url
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://mp3quran.net/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        //finally return the retrofit
        return retrofit;
    }

    public static APICalls getAPIS(){
        return getInstance().create(APICalls.class);
    }
}
