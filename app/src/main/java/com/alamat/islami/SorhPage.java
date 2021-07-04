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

    RecycleViewAdapterContent adapter;
    RecyclerView.LayoutManager layoutManager;

    String sorhName,fileName;
    int indexOfSorh;
    ArrayList<String> text ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sorh_page);


//        Intent intent = getIntent();
//        sorhName = intent.getStringExtra("sorhName");
//        binding.tvSorhName.setText(sorhName);
//        indexOfSorh = intent.getIntExtra("indexOfSorh");

        Bundle extra = getIntent().getExtras();
        sorhName = "سورة " + extra.getString("sorhName");
        binding.tvSorhName.setText(sorhName);

        indexOfSorh = extra.getInt("indexOfSorh");
//        binding.tvSorhName.setText(Integer.toString(indexOfSorh));
        for(int i=0; i<QuranFragment.listOfSewarNames.length; i++){
            if( i == indexOfSorh){
                fileName = i+1 + ".txt";
                 text  = getContent(fileName);
            }
        }

        adapter = new RecycleViewAdapterContent(text);
        layoutManager = new LinearLayoutManager(this);

        binding.recyclerViewContent.setAdapter(adapter);
        binding.recyclerViewContent.setLayoutManager(layoutManager);

    }

    private ArrayList<String> getContent(String fileName) {

        ArrayList<String> contentLines = null;
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
                contentLines = new ArrayList<>(countLines);
                for (int i = 0; i < countLines; i++) {
                    contentLines.add(bufferedReader.readLine());
                }
            } catch (Exception f) {
                f.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentLines;
    }

//        int countLines = 0;
//        ArrayList<String> text = null;
//
//        try {
//
//            InputStream inputStream = getAssets().open(fileName);
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//
//            while (reader.readLine() != null) {
//
//                text.add(reader.readLine());
//                countLines++;
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception f) {
//            f.printStackTrace();
//        }
//
//        return text;

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
//                    InputStream inputStream = getAssets().open(".txt");
//                    int size = inputStream.available();
//                    byte[] buffer = new byte[size];
//                    inputStream.read(buffer);
//                    lines = new String[buffer.length];
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } catch (Exception f) {
////            f.printStackTrace();
////        }
//        });

}
