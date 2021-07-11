package com.alamat.islami.RecyclerViewAdapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.alamat.islami.R;
import com.alamat.islami.databinding.ItemAthkarBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerViewAdapterAthkar extends RecyclerView.Adapter<RecyclerViewAdapterAthkar.ViewHolder> {

    ArrayList<String> athkar;

    public RecyclerViewAdapterAthkar(ArrayList<String> athkar) {
        this.athkar = athkar;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemAthkarBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_athkar,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.itemAthkarBinding.tvContent.setText(athkar.get(position));
    }

    @Override
    public int getItemCount() {
        if(athkar == null){
            return 0;
        }else {
            return athkar.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
    ItemAthkarBinding itemAthkarBinding;
        public ViewHolder( ItemAthkarBinding athkarBinding) {
            super(athkarBinding.getRoot());
            this.itemAthkarBinding = athkarBinding;
        }
    }
}
