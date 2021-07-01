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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private String[] ListModels;

    int itemView;

    public static final int LIST = 100;
    public static final int GIRD = 200;

    OnItemClickedListener onItemClickedListener;

    public RecyclerViewAdapter(String[] ListModel, int typeView) {
        this.ListModels = ListModel;
        this.itemView = typeView;
    }

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        //Quran List
        if(itemView == LIST){
            ItemQuranListBinding listBinding = DataBindingUtil
                    .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_quran_list ,parent, false);
            return new ViewHolder(listBinding);

            //Hadeth List
        }else if (itemView == GIRD) {
            ItemHadethListBinding gridbinding = DataBindingUtil
                    .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_hadeth_list ,parent, false);
            return new ViewHolder(gridbinding);

            // default for Quran items
        }else{
            ItemQuranListBinding listBinding = DataBindingUtil.
                    inflate(LayoutInflater.from(parent.getContext()), R.layout.item_quran_list ,parent,false);
            return new ViewHolder(listBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        String listModel = ListModels[position];

        //Quran
        if(itemView == LIST)
        {
            holder.listBinding.tvSorhName.setText(ListModels[position]);

            //Hadeth
        }else if(itemView == GIRD){
            holder.gridBinding.tvHadethName.setText(ListModels[position]);
        }


        if(onItemClickedListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickedListener.onItemClick(position,ListModels);
                }
            });
        }
    }

    @Override
    public int getItemCount() {

        if(ListModels == null){
            return 0;
        } else {
            return ListModels.length;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ItemQuranListBinding listBinding;
        ItemHadethListBinding gridBinding;

        //for Quran view
        public ViewHolder(ItemQuranListBinding listBinding) {
            super(listBinding.getRoot());
            this.listBinding = listBinding;
        }

        //for Hadeth view
        public ViewHolder(ItemHadethListBinding gridBinding) {
            super(gridBinding.getRoot());
            this.gridBinding = gridBinding;
        }

    }

    //interface for each item
    public interface OnItemClickedListener{
         void onItemClick(int position, String[] quranListModels);
    }


}
