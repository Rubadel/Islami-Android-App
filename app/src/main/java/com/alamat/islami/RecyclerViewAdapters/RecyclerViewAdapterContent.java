package com.alamat.islami.RecyclerViewAdapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.alamat.islami.R;
import com.alamat.islami.databinding.ItemContentBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerViewAdapterContent extends RecyclerView.Adapter<RecyclerViewAdapterContent.ViewHolder>  {

    ArrayList<String> contentLines;

    public RecyclerViewAdapterContent(ArrayList<String> contentLines) {
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
