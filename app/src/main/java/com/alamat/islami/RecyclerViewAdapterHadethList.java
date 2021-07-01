package com.alamat.islami;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.alamat.islami.databinding.ItemHadethListBinding;
import com.alamat.islami.databinding.ItemQuranListBinding;

import org.jetbrains.annotations.NotNull;

public class RecyclerViewAdapterHadethList extends RecyclerView.Adapter<RecyclerViewAdapterHadethList.ViewHolder>{

    private String hadethListModels[];

    public RecyclerViewAdapterHadethList(String[] hadethListModels) {
        this.hadethListModels = hadethListModels;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       ItemHadethListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_hadeth_list,parent,false);
       return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        holder.listBinding.tvHadethhName.setText(hadethListModels[position]);

    }

    @Override
    public int getItemCount() {
        if(hadethListModels == null){
            return 0;
        } else {
            return hadethListModels.length;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ItemHadethListBinding listBinding;
        public ViewHolder(ItemHadethListBinding hadethListBinding) {
            super(hadethListBinding.getRoot());
            this.listBinding = hadethListBinding;
        }
    }
}
