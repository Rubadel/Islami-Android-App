package com.alamat.islami;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.alamat.islami.databinding.ItemQuranListBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerViewAdapterQuranList extends RecyclerView.Adapter<RecyclerViewAdapterQuranList.ViewHolder>{


    private String quranListModels[];

    OnItemClickedListener onItemClickedListener;

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    public RecyclerViewAdapterQuranList(String[] quranListModels) {
        this.quranListModels = quranListModels;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemQuranListBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_quran_list ,parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        holder.listBinding.tvSorhName.setText(quranListModels[position]);

        if(onItemClickedListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickedListener.onItemClick(position,quranListModels);
                }
            });
        }
    }

    @Override
    public int getItemCount() {

        if(quranListModels == null){
            return 0;
        } else {
            return quranListModels.length;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ItemQuranListBinding listBinding;
        public ViewHolder(ItemQuranListBinding quranListBinding) {
            super(quranListBinding.getRoot());
            this.listBinding = quranListBinding;
        }
    }

    public interface OnItemClickedListener{
         void onItemClick(int position, String[] quranListModels);
    }

}
