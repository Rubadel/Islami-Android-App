package com.alamat.islami;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.alamat.islami.databinding.ItemContentBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerViewAdapterConent extends RecyclerView.Adapter<RecyclerViewAdapterConent.ViewHolder> {

    private String[] contentModels;

    public RecyclerViewAdapterConent(String[] contentModels) {
        this.contentModels = contentModels;
    }

    RecyclerViewAdapterConent.OnItemClickedListener onItemClickedListener;

    public void setOnItemClickedListener(RecyclerViewAdapterConent.OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
            ItemContentBinding contentBinding = DataBindingUtil
                    .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_content ,parent, false);
            return new ViewHolder(contentBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        String contactModel = contentModels[position];

        holder.contentBinding.tvContent.setText(contentModels[position]);


        if (onItemClickedListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    onItemClickedListener.onItemClick(position, contentModels);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (contentModels == null) {
            return 0;
        } else {

            return contentModels.length;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemContentBinding contentBinding;

        public ViewHolder(ItemContentBinding contentBinding) {
            super(contentBinding.getRoot());
            this.contentBinding = contentBinding;
        }
    }

    public interface OnItemClickedListener {
        void onItemClick(int position, String[] lines);
    }
}



