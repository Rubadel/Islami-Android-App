package com.alamat.islami;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.loader.AssetsProvider;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alamat.islami.databinding.FragmentQuranBinding;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class QuranFragment extends Fragment {

    FragmentQuranBinding binding;
    View view;

    RecyclerViewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    public static String[] listOfSewarNames ={"الفاتحة","البقرة","آل عِمْران","النسَاء","المائدة","الأنعَام","الأعراف","الأنفال","التوبَة","يونس","هُود"
            ,"یوسُف","الرّعد","إبراهيم","الحِجر","النحل","الإسرَاء","الكهف","مَریم","طه","الأنبیَاء","الحَج","المؤمِنون"
            ,"النّور","الفُرقان","الشُّعَراء","النّمل","القصص","العنكبوت","الرّوم","لقمان","السجدة","الأحزاب","سبأ"
            ,"فاطِر","يس","الصّافّات","صۤ","الزمَر","غافِر","فصّلت","الشورى","الزخرف","الدخَان","الجاثيَة","الأحقاف"
            ,"محمد","الفتح","الحجرات","قۤ","الذاريات","الطور","النجم","القمَر","الرحمن","الواقعة","الحديد","المجادلة"
            ,"الحشر","الممتحنة","الصّف","الجمعة","المنافقون","التغابُن","الطلاق","التحريم","الملك","القلم","الحاقة","المعَارِج"
            ,"نوح","الجِنّ","المزمّل","المدّثر","القيَامة","الإنسان","المرسَلات","النّبَأ","النّازعَات","عبَس","التكوير","الإنفطار"
            ,"المطفّفين","الانشِقَاق","البُروج","الطّارق","الأعلىٰ","الغَاشِيَة","الفجْر","البَلد","الشمس","الليل","الضّحَىٰ","الشّرْح"
            ,"التين","العَلَق","القدْر","البیّنة","الزَّلزّلة","العَاديَات","القارعَة","التكاثر","العَصر",
            "الهُمَزة","الفِیل","قريش","الماعُون","الكوثر","الكافِرون","النّصر","المسَد","الإخلاص","الفَلَق","الناس"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quran,container,false);

        // RecyclerView set up
        adapter = new RecyclerViewAdapter(listOfSewarNames, RecyclerViewAdapter.LISTlist);
        layoutManager = new LinearLayoutManager(getContext());

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(layoutManager);

        //<./>


        //go to item page
        adapter.setOnItemClickedListener(new RecyclerViewAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(int position, String[] ListModels) {
                int indexOfPosition = position;
                Intent intent = new Intent(getContext(), SorhPage.class);
                intent.putExtra("sorhName", listOfSewarNames[position]);
                intent.putExtra("indexOfSorh", indexOfPosition);
                startActivity(intent);
            }
        });
        //</.>


        view = binding.getRoot();
        return view;
    }
}

