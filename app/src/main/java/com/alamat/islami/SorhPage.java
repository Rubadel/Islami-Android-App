package com.alamat.islami;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.alamat.islami.databinding.ActivitySorhPageBinding;

public class SorhPage extends AppCompatActivity {

    ActivitySorhPageBinding binding;
    String NameOfSorh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sorh_page);

        Intent i = getIntent();
        // getIntent().getExtras().getString("sorhName");
        NameOfSorh = i.getStringExtra("sorhName");
        binding.tvSorhName.setText(NameOfSorh);

    }
}