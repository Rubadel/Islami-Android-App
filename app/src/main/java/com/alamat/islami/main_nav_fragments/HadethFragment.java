package com.alamat.islami.main_nav_fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alamat.islami.R;
import com.alamat.islami.RecyclerViewAdapters.RecyclerViewAdapterLists;
import com.alamat.islami.databinding.FragmentHadethBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HadethFragment extends Fragment {

    FragmentHadethBinding binding;
    View view;

    RecyclerViewAdapterLists adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<String> contentLines;


    public static String[] listOfAhadethNames = {"الحديث الأول","الحديث الثاني","الحديث الـثـالـث","الحديث الـرابع","الحديث الخامس","الحديث السادس","الحديث السابع","الحديث الثامن","الحديث التاسع","الحديث العاشر",
            "الحديث الحادي عشر","الحديث الثانى عشر","الحديث الثالث عشر","الحد يث الرابع عشر","الحديث الخامس عشر","الحديث السادس عشر","الحديث السابع عشر","الحد يث الثامن عشر","الحد يث التاسع عشر","الحديث العشرون",
            "الحديث الحادي والعشرون","الحديث الثانى والعشرون","الحديث الثالث والعشرون","الحديث الرابع والعشرون","الحديث الخامس والعشرون","الحديث السادس والعشرون","الحديث السابع والعشرون","الحديث الثامن والعشرون","الحديث التاسع والعشرون","الحديث الثلاثون",
            "الحديث الحادي والثلاثون","الحديث الثانى والثلاثون","الحديث الثالث والثلاثون","الحديث الرابع والثلاثون","الحديث الخامس والثلاثون","الحديث السادس والثلاثون","الحديث السابع والثلاثون","الحديث الثامن والثلاثون","الحديث التاسع والثلاثون","الحديث الأربعون",
            "الحديث الحادي والأربعون","الحديث الثانى والأربعون","الحديث الثالث والأربعون","الحديث الرابع والأربعون","الحديث الخامس والأربعون","الحديث السادس والأربعون","الحديث السابع والأربعون","الحديث الثامن والأربعون","الحديث التاسع والأربعون","الحديث الخمسون", };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hadeth,container,false);


        //for RecyclerView
        adapter = new RecyclerViewAdapterLists(listOfAhadethNames, RecyclerViewAdapterLists.GIRDlist );
        layoutManager = new GridLayoutManager(getContext(),3);

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(layoutManager);

        //<./>


        //get content hadeths file
        contentLines = getContent("ahadeth.txt");
        //<./>

        //go to item content
        adapter.setOnItemClickedListener(new RecyclerViewAdapterLists.OnItemClickedListener() {
            @Override
            public void onItemClick(int position, String ListModels) {
                opendialog(listOfAhadethNames[position],contentLines.get(position));
            }
        });
        //<./>


        view = binding.getRoot();
        return view;
    }


    //reade single hadeth
    private ArrayList<String> getContent(String fileName) {

        ArrayList<String> singleHadeth =null;
        InputStream stream;
        BufferedReader reader;

        int countLines = 0;
        ArrayList<String> hadethcontent = new ArrayList<>(countLines);
        String readerLines,lines;


        try {
            stream = getContext().getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(stream));

            try {
                while ( (readerLines = reader.readLine()) != null) {
                     lines = readerLines;

                    while ((readerLines = reader.readLine()) != null) {

                        //detect the limit line with # symbol
                        String limit = (readerLines.trim());
                        //then cut the content
                        if("#".equals(limit)){
                            break;
                         }
                        lines = lines + " \n " + readerLines;
                    }
                    hadethcontent.add(lines);
                }
                singleHadeth = hadethcontent;

            } catch (Exception f) {
                f.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return singleHadeth;
    }
    // <./>

    //Dialog
    public void opendialog(String name, String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.MyDialogTheme);
        builder.setTitle(name);
        builder.setMessage(content);
        builder.setPositiveButton("رجوع",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        dialog.dismiss();
                    }
                });
        builder.show();
    }
}
