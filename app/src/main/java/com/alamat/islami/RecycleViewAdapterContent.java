package com.alamat.islami;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.alamat.islami.databinding.ItemContentBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecycleViewAdapterContent extends RecyclerView.Adapter<RecycleViewAdapterContent.ViewHolder>  {

    ArrayList<String> contentLines;

    public RecycleViewAdapterContent(ArrayList<String> contentLines) {
        this.contentLines = contentLines;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContentBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_content,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemContentBinding.tvContent.setText(contentLines.get(position));
    }

    @Override
    public int getItemCount() {
        if(contentLines == null){
            return 0;
        }
        else {
            return contentLines.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ItemContentBinding itemContentBinding;
        public ViewHolder(ItemContentBinding itemContentBinding) {
            super(itemContentBinding.getRoot());
            this.itemContentBinding = itemContentBinding;
        }
    }

    public interface onItemClickListener {
        void onItemClick(int position, String content);
    }

}
