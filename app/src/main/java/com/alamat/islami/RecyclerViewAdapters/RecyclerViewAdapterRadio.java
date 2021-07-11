package com.alamat.islami.RecyclerViewAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.alamat.islami.R;
import com.alamat.islami.Radio.RadioModels.RadioItem;
import com.alamat.islami.databinding.RadioItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerViewAdapterRadio extends RecyclerView.Adapter<RecyclerViewAdapterRadio.ViewHolder>{

    List<RadioItem> radioModelList;

    OnItemClickListener onPlatClickListener;
    OnItemClickListener onStopClickListener;

    public RecyclerViewAdapterRadio(List<RadioItem> dataModelList) {
        this.radioModelList = dataModelList;
    }

    public void setOnPlatClickListener(OnItemClickListener onPlatClickListener) {
        this.onPlatClickListener = onPlatClickListener;
    }

    public void setOnStopClickListener(OnItemClickListener onStopClickListener) {
        this.onStopClickListener = onStopClickListener;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        RadioItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.radio_item,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        RadioItem radioItem = radioModelList.get(position);
        holder.binding.tvRadioName.setText(radioItem.getName());
//        holder.binding.tvRadioURL.setText(radioItem.getuRL());

        //play btn
        if (onPlatClickListener != null){
            holder.binding.btnPlay.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    onPlatClickListener.onItemClick(position , radioItem);
                }
            });
        }

        //stop btn

        if(onStopClickListener != null){
            holder.binding.btnStop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onStopClickListener.onItemClick(position , radioItem);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        if (radioModelList == null){
            return 0;
        }else {
            return radioModelList.size();
        }
    }


    public void changeData(List<RadioItem> items){
        radioModelList = items;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener{
        void onItemClick(int position, RadioItem radioItem);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RadioItemBinding binding;
        public ViewHolder(RadioItemBinding recyclerItemBinding) {
            super(recyclerItemBinding.getRoot());
            this.binding = recyclerItemBinding;
        }
    }
}
