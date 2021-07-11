package com.alamat.islami;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alamat.islami.apiRadio.APImodels.RadioItem;
import com.alamat.islami.apiRadio.APImodels.RadioResponseModel;
import com.alamat.islami.apiRadio.Newtwork.apiManager;
import com.alamat.islami.databinding.FragmentRadioBinding;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RadioFragment extends Fragment {

    FragmentRadioBinding binding;
    View view;

    RecyclerViewAdapterRadio adapter;
    RecyclerView.LayoutManager layoutManager;

    SnapHelper snapHelper;

    MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_radio,container,false);

        adapter = new RecyclerViewAdapterRadio(null);
        layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(layoutManager);

        callRadios();

        snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(binding.recyclerView);

        adapter.setOnPlatClickListener(new RecyclerViewAdapterRadio.OnItemClickListener() {
            @Override
            public void onItemClick(int position, RadioItem radioItem) {
                //play radio
                playRadio(radioItem.getURL());

            }
        });

        adapter.setOnStopClickListener(new RecyclerViewAdapterRadio.OnItemClickListener() {
            @Override
            public void onItemClick(int position, RadioItem radioItem) {
                //stop radio
                stopRadio();

            }
        });


        view = binding.getRoot();
        return view;
    }

    public void callRadios() {
        apiManager.getAPIS().getRadio().enqueue(new Callback<RadioResponseModel>() {
            @Override
            public void onResponse(Call<RadioResponseModel> call, Response<RadioResponseModel> response) {

                    adapter.changeData(response.body().getRadios());
            }

            @Override
            public void onFailure(Call<RadioResponseModel> call, Throwable t) {

                Log.e("TAG", "onFailure: " + t.getLocalizedMessage());

            }
        });
    }

    public void stopRadio(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
    }

    public void playRadio(String URL){
        stopRadio();
        mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource(URL);
            mediaPlayer.prepareAsync();

            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
        }catch (IOException e){
            Toast.makeText(getContext(),"The ERROR is " + e.fillInStackTrace() , Toast.LENGTH_SHORT).show();
        }
    }

}