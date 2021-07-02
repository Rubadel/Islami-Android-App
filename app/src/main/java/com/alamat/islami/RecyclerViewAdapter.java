package com.alamat.islami;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.alamat.islami.databinding.ItemContentBinding;
import com.alamat.islami.databinding.ItemHadethListBinding;
import com.alamat.islami.databinding.ItemQuranListBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private String[] ListModels;
    int typeView;

//    String[] contentModels ;

    List<contentModel> contentModels;

    public static final int LISTlist = 100;
    public static final int GIRDlist = 200;
    public static final int CONTENT = 300;


    public RecyclerViewAdapter(String[] ListModel, int typeView) {
        this.ListModels = ListModel;
        this.typeView = typeView;
    }

//
//    public RecyclerViewAdapter(String[] contentModels) {
//        this.contentModels = contentModels;
//    }

    public RecyclerViewAdapter(List<contentModel> contentModels) {
        this.contentModels = contentModels;
    }

    OnItemClickedListener onItemClickedListener;

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        //Quran List
        if (typeView == LISTlist) {
            ItemQuranListBinding listBinding = DataBindingUtil
                    .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_quran_list, parent, false);
            return new ViewHolder(listBinding);

            //Hadeth List
        } else if (typeView == GIRDlist) {
            ItemHadethListBinding gridbinding = DataBindingUtil
                    .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_hadeth_list, parent, false);
            return new ViewHolder(gridbinding);

        }else if (typeView == CONTENT) {
            ItemContentBinding contentBinding = DataBindingUtil
                    .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_content ,parent, false);
            return new ViewHolder(contentBinding);

//             default for Quran items
        } else {
            ItemQuranListBinding listBinding = DataBindingUtil.
                    inflate(LayoutInflater.from(parent.getContext()), R.layout.item_quran_list, parent, false);
            return new ViewHolder(listBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        String listModel = ListModels[position];
        contentModel contactModel = contentModels.get(position);

        //Quran
        if (typeView == LISTlist) {
            holder.listBinding.tvSorhName.setText(ListModels[position]);

            //Hadeth
        } else if (typeView == GIRDlist) {
            holder.gridBinding.tvHadethName.setText(ListModels[position]);
        }

        // ************* //Content **************
        else if(typeView == CONTENT){
        holder.contentBinding.tvContent.setText(contactModel.line);
    }

        if (onItemClickedListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickedListener.onItemClick(position, ListModels);
                }
            });
        }
    }

    @Override
    public int getItemCount() {

        int countReturend =0;
        //return list count
        if (typeView == LISTlist || typeView == GIRDlist) {
            if (ListModels == null) {
                countReturend= 0;
            } else {

                countReturend= ListModels.length;
            }
        }

        //return content count
        else if (typeView == CONTENT) {

            if (contentModels == null) {
                countReturend= 0;
            } else {

                countReturend= contentModels.size();
            }
        }

        return countReturend;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ItemQuranListBinding listBinding;
        ItemHadethListBinding gridBinding;
        ItemContentBinding contentBinding;

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

//        content
        public ViewHolder(ItemContentBinding contentBinding) {
            super(contentBinding.getRoot());
            this.contentBinding = contentBinding;
        }
    }


    //interface for each item
    public interface OnItemClickedListener {
        void onItemClick(int position, String[] ListModels);
    }
}

