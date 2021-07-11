package com.alamat.islami;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.alamat.islami.databinding.AthkarFragmentBinding;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;


public class AthkarFragment extends Fragment {

    AthkarFragmentBinding binding;
    View view;

//    FragmentPagerItemAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.athkar_fragment, container, false);
         initTablayout();
        view = binding.getRoot();
        return view;
    }

    public void initTablayout(){
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                //getSupportFragmentManager
                getParentFragmentManager(), FragmentPagerItems.with(getContext())
                .add("سبحة", SebhaFragment.class)
                .add("أذكار الصباح و المساء", MNathkarfragment.class)
                .create());

        binding.viewPager.setAdapter(adapter);
        binding.tablayout.setViewPager(binding.viewPager);

        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                binding.viewPager.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    
}