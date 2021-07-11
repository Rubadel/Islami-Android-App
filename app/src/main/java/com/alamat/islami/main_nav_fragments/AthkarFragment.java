package com.alamat.islami.main_nav_fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alamat.islami.R;
import com.alamat.islami.databinding.FragmentAthkarBinding;
import com.alamat.islami.pages.morningAthkar;
import com.alamat.islami.pages.nightAthkar;


public class AthkarFragment extends Fragment {

    FragmentAthkarBinding binding;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_athkar, container, false);
        // Inflate the layout for this fragment

        binding.btnSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), morningAthkar.class);
                startActivity(intent);
            }
        });

        binding.btnNight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), nightAthkar.class);
                startActivity(intent);
            }
        });

        view = binding.getRoot();
        return view;
    }
    
}