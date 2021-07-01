package com.alamat.islami;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.alamat.islami.databinding.FragmentSebhaBinding;


public class SebhaFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    FragmentSebhaBinding binding;
    View view;

    String choice;
    int choicenum, singelCount,totalCount = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sebha,container,false);
        view = binding.getRoot();

        //for spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.athkar, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);
        binding.spinner.setOnItemSelectedListener(this);
        //</.>

        //Btns function
        singelCounter();
        resetTotalCounter();

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        // to get selected choice = adapterView.getItemAtPosition(position).toString();

         switch (position)
         {
             case 0:
                 singelCounter();
                 break;
             case 1:
                 singelCounter();
                 break;
             case 2:
                 singelCounter();
                 break;
         }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }


    public void singelCounter( )
    {
        //to reset count with each calling
        singelCount = 0;
        binding.tvSingelCount.setText(Integer.toString(singelCount));

        //counter with pressed btn
        binding.btnCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singelCount = singelCount+1;
                totalCount = totalCount+1;
                binding.tvSingelCount.setText(Integer.toString(singelCount)); //single counter
                binding.tvTotalCount.setText(Integer.toString(totalCount)); //total counter
            }
        });
    }

    public void resetTotalCounter(){
        binding.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalCount = 0;
                binding.tvTotalCount.setText(Integer.toString(totalCount));
            }
        });
    }

}