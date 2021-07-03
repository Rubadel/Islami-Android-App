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
import java.util.Arrays;
import java.util.List;

public class SorhPage extends AppCompatActivity {

    ActivitySorhPageBinding binding;

    RecyclerViewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    String sorhName;
    int indexOfSorh;
    String fileName;
    public ArrayList<String> contentLines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sorh_page);


        Intent intent = getIntent();
        sorhName = intent.getStringExtra("sorhName");
        binding.tvSorhName.setText(sorhName);

        indexOfSorh = intent.getIntExtra("indexOfPosition",indexOfSorh);

        for(int i=0; i<QuranFragment.listOfSewarNames.length; i++){
            if( i == indexOfSorh){
                fileName = i+1 + ".txt";
                contentLines = getContent(fileName);
            }
        }

        adapter = new RecyclerViewAdapter((ArrayList<String>) contentLines);
        layoutManager = new LinearLayoutManager(this);

        binding.recyclerViewLines.setAdapter(adapter);
        binding.recyclerViewLines.setLayoutManager(layoutManager);

    }

    private ArrayList<String> getContent(String fileName) {


//        try {
//            InputStream inputStream = getAssets().open("myText.txt");
//            int size = inputStream.available();
//            byte[] buffer = new byte[size];
//            inputStream.read(buffer);
//            lines = new String[buffer.length];
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        adapterConent.setOnItemClickedListener(new RecyclerViewAdapterConent.OnItemClickedListener() {
//            @Override
//            public void onItemClick(int position, String[] lines) {
//                try {
//                    InputStream inputStream = getAssets().open("myText.txt");
//                    int size = inputStream.available();
//                    byte[] buffer = new byte[size];
//                    inputStream.read(buffer);
//                    lines = new String[buffer.length];
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        try {

            InputStream inputStream = getAssets().open(fileName);

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            int cont = 0;


            while (reader.readLine() != null) {

                contentLines.add(reader.readLine());
                cont++;

            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        return contentLines;
    }
}
