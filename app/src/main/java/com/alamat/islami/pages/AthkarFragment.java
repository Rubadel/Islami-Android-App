package com.alamat.islami.pages;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alamat.islami.R;
import com.alamat.islami.databinding.FragmentAthkarBinding;


public class AthkarFragment extends Fragment {

    FragmentAthkarBinding binding;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_athkar, container, false);
        // Inflate the layout for this fragment

//        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
//                getChildFragmentManager(), FragmentPagerItems.with(getContext())
//                .add("أذكار الصباح", athkarMorningFragment.class)
//                .add("أذكار المساء", athkarNightFragment.class)
//                .create());
//        binding.viewpager.setAdapter(adapter);
//        binding.tablayout.setViewPager(binding.viewpager);
//
//        binding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                binding.viewpager.getAdapter().notifyDataSetChanged();
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

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


//    public void initTablayout(){
//        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
//                getChildFragmentManager(), FragmentPagerItems.with(getContext())
//                .add("أذكار الصباح", athkarMorningFragment.class)
//                .add("أذكار المساء", athkarNightFragment.class)
//                .create());
//
//
//        binding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                binding.viewpager.getAdapter().notifyDataSetChanged();
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//    }

}