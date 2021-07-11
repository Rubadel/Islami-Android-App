package com.alamat.islami;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.alamat.islami.databinding.ActivityMainBinding;
import com.alamat.islami.main_nav_fragments.AthkarFragment;
import com.alamat.islami.main_nav_fragments.HadethFragment;
import com.alamat.islami.main_nav_fragments.QuranFragment;
import com.alamat.islami.main_nav_fragments.RadioFragment;
import com.alamat.islami.main_nav_fragments.SebhaFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.navBar.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fram_layout, new QuranFragment()).commit();
    }


    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;

            if (getSupportFragmentManager().findFragmentById(R.id.nav_bar) == null) {

                fragment = new QuranFragment();
            }

            switch (item.getItemId()) {
                case R.id.quran_btn_nav:
                    fragment = new QuranFragment();
                    break;

                case R.id.hadeth_btn_nav:

                    fragment = new HadethFragment();
                    break;

                case R.id.sebha_btn_nav:
                    fragment = new SebhaFragment();
                    break;

                case R.id.radio_btn_nav:
                    fragment = new RadioFragment();
                    break;
                case R.id.athkar_btn_nav:
                    fragment = new AthkarFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fram_layout, fragment).commit();
            return true;
        }
    };

}