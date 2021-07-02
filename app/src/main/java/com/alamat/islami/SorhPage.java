package com.alamat.islami;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.alamat.islami.databinding.ActivitySorhPageBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SorhPage extends AppCompatActivity {

    ActivitySorhPageBinding binding;
    String sorhName;


    RecyclerViewAdapterConent adapterConent;
    RecyclerView.LayoutManager layoutManager;
    String[] lines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sorh_page);

        Intent i = getIntent();
        // getIntent().getExtras().getString("sorhName");
        sorhName = i.getStringExtra("sorhName");
        binding.tvSorhName.setText(sorhName);


        adapterConent = new RecyclerViewAdapterConent(lines);
        layoutManager = new LinearLayoutManager(this);

        binding.recyclerViewLines.setAdapter(adapterConent);
        binding.recyclerViewLines.setLayoutManager(layoutManager);

        adapterConent.setOnItemClickedListener(new RecyclerViewAdapterConent.OnItemClickedListener() {
            @Override
            public void onItemClick(int position, String[] lines) {
                try {
                    InputStream inputStream = getAssets().open("myText.txt");
                    int size = inputStream.available();
                    byte[] buffer = new byte[size];
                    inputStream.read(buffer);
                    lines = new String[buffer.length];
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
