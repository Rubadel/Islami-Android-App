package com.alamat.islami;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.alamat.islami.databinding.ActivitySorhPageBinding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SorhPage extends AppCompatActivity {

    ActivitySorhPageBinding binding;
    String sorhName;

    String[] lines;
    RecyclerViewAdapterConent recyclerViewAdapterConent;

    List<contentModel> contentModels;

//    List<contentModel> contentModelLines = new ArrayList<contentModel>();
//    try ( BufferedReader bufferedReader = new BufferedReader(
//            new InputStreamReader(getAssets().open("text1")))){
//        String line = "";
//        int i =0;
//
//        while ((line = bufferedReader.readLine()) != null){
//            contentModel contentModel = new contentModel();
//
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sorh_page);

        Intent i = getIntent();
        // getIntent().getExtras().getString("sorhName");
        sorhName = i.getStringExtra("sorhName");
        binding.tvSorhName.setText(sorhName);

    }
}