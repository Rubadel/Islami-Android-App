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

public class HadethFragment extends Fragment {

    FragmentHadethBinding binding;
    View view;

    //for RecyclerView
    RecyclerViewAdapterList adapter;
    RecyclerView.LayoutManager layoutManager;

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

        view = binding.getRoot();

        //for RecyclerView
        adapter = new RecyclerViewAdapterList(listOfAhadethNames, RecyclerViewAdapterList.GIRDlist );
        layoutManager = new GridLayoutManager(getContext(),2);

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(layoutManager);

        //<./>

        //go to item page
        adapter.setOnItemClickedListener(new RecyclerViewAdapterList.OnItemClickedListener() {
            @Override
            public void onItemClick(int position, String quranListModels) {
                showDialog();
                Intent intent = new Intent(getContext(), SorhPage.class);
                intent.putExtra("hadethName",listOfAhadethNames[position]);
                startActivity(intent);
            }
        });
        //<./>

        return view;
    }

    private void showDialog(){

        Dialog dialog = new Dialog(getContext());
//        dialog.setContentView();
//        binding = DataBindingUtil.setContentView(getActivity(), R.layout.activity_hadeth_page);
        dialog.setContentView(R.layout.activity_hadeth_page);
        dialog.show();
    }
}