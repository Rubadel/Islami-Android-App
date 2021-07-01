package com.alamat.islami;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.alamat.islami.databinding.ActivityHadethPageBinding;
import com.alamat.islami.databinding.ActivitySorhPageBinding;

public class HadethPage extends AppCompatActivity {

    ActivityHadethPageBinding binding;
    String hadethName;

    int width,height ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hadeth_page);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

         width = dm.widthPixels;
         height = dm.heightPixels;

         getWindow().setLayout((int)(width*.8),(int)(height*.6));

        Intent i = getIntent();
        // getIntent().getExtras().getString("sorhName");
        hadethName = i.getStringExtra("hadethName");
        binding.tvHadethName.setText(hadethName);

    }
}