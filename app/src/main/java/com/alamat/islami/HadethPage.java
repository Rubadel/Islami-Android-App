package com.alamat.islami;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.alamat.islami.databinding.ActivityHadethPageBinding;
import com.alamat.islami.databinding.ActivitySorhPageBinding;

public class HadethPage extends AppCompatActivity {

    ActivityHadethPageBinding binding;
    String hadethName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hadeth_page);


        Intent i = getIntent();
        // getIntent().getExtras().getString("sorhName");
        hadethName = i.getStringExtra("hadethName");
        binding.tvHadethName.setText(hadethName);

    }
}