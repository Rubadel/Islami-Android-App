package com.alamat.islami.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alamat.islami.MainActivity;
import com.alamat.islami.R;
import com.alamat.islami.RecyclerViewAdapters.RecyclerViewAdapterAthkar;
import com.alamat.islami.databinding.ActivityNightAthkarBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class nightAthkar extends AppCompatActivity {

    ActivityNightAthkarBinding binding;

    RecyclerViewAdapterAthkar adapter;
    RecyclerView.LayoutManager layoutManager;

    String title;
    ArrayList<String> content ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_night_athkar);

        content = getContnet("masaAthkar.txt");

        //for RecyclerView
        adapter = new RecyclerViewAdapterAthkar(content);
        layoutManager = new LinearLayoutManager(this);

        binding.recyclerViewAthkar.setAdapter(adapter);
        binding.recyclerViewAthkar.setLayoutManager(layoutManager);
        //<./>

    }

    //get Athkar file content
    private ArrayList<String> getContnet(String fileName) {
        ArrayList<String> txt = null;
        InputStream inputStream, stream;
        BufferedReader bufferedReader, reader;
        int countLines = 0;

        try {
            stream = getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(stream));
            try {
                while (reader.readLine() != null) {
                    countLines++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            inputStream = getAssets().open(fileName);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            try {
                txt = new ArrayList<>(countLines);
                for (int i = 0; i < countLines; i++) {
                    txt.add(bufferedReader.readLine());
                }
            } catch (Exception f) {
                f.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return txt;
    }

    public void returnBack(View v){
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
        onBackPressed();
    }
}