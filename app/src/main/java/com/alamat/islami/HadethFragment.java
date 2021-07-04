package com.alamat.islami;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alamat.islami.databinding.FragmentHadethBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class HadethFragment extends Fragment {

    FragmentHadethBinding binding;
    View view;

    //for RecyclerView
    RecyclerViewAdapterList adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<String> contentLines, singleHadeth;

    String lines;

    public static String[] listOfAhadethNames = {"الحديث الأول","الحديث الثاني","الحديث الـثـالـث","الحديث الـرابع","الحديث الخامس","الحديث السادس","الحديث السابع","الحديث الثامن","الحديث التاسع","الحديث العاشر",
            "الحديث الحادي عشر","الحديث الثانى عشر","الحديث الثالث عشر","الحد يث الرابع عشر","الحديث الخامس عشر","الحديث السادس عشر","الحديث السابع عشر","الحد يث الثامن عشر","الحد يث التاسع عشر","الحديث العشرون",
            "الحديث الحادي والعشرون","الحديث الثانى والعشرون","الحديث الثالث والعشرون","الحديث الرابع والعشرون","الحديث الخامس والعشرون","الحديث السادس والعشرون","الحديث السابع والعشرون","الحديث الثامن والعشرون","الحديث التاسع والعشرون","الحديث الثلاثون",
            "الحديث الحادي والثلاثون","الحديث الثانى والثلاثون","الحديث الثالث والثلاثون","الحديث الرابع والثلاثون","الحديث الخامس والثلاثون","الحديث السادس والثلاثون","الحديث السابع والثلاثون","الحديث الثامن والثلاثون","الحديث التاسع والثلاثون","الحديث الأربعون",
            "الحديث الحادي والأربعون","الحديث الثانى والأربعون","الحديث الثالث والأربعون","الحديث الرابع والأربعون","الحديث الخامس والأربعون","الحديث السادس والأربعون","الحديث السابع والأربعون","الحديث الثامن والأربعون","الحديث التاسع والأربعون","الحديث الخمسون", };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_hadeth,container,false);

        //for RecyclerView
        adapter = new RecyclerViewAdapterList(listOfAhadethNames, RecyclerViewAdapterList.GIRDlist );
        layoutManager = new GridLayoutManager(getContext(),2);

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(layoutManager);

        //<./>

        //go to item page
        adapter.setOnItemClickedListener(new RecyclerViewAdapterList.OnItemClickedListener() {
            @Override
            public void onItemClick(int position, String ListModels) {

                contentLines = getContent("ahadeth.txt");
                openDialog();
            }
        });
        //<./>

        view = binding.getRoot();
        return view;
    }

    private ArrayList<String> getContent(String fileName) {

        InputStream stream;
        BufferedReader reader;
        int countLinesOfText = 0;

        try {
            stream = getContext().getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(stream));


            try {
                for(String l = reader.readLine(); l != null; l=l+1)
                while (l != null) {
                    lines = l;
                    if (l.equals("#")) {
                            break;
                        }

                        lines = lines + "\n" + l;
                    singleHadeth.add(lines);

                }
                singleHadeth = singleHadeth;


            } catch (Exception f) {
                f.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return singleHadeth;
    }


    private void openDialog(){
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.activity_hadeth_page);
        dialog.show();
    }
}