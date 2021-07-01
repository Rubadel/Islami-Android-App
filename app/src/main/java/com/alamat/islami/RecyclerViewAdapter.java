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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private String[] ListModels;
    int itemView;
// private ArrayList<contentModel> contentModels;

    public static final int LISTlist = 100;
    public static final int GIRDlist = 200;
//    public static final int CONTENT = 300;


    public RecyclerViewAdapter(String[] ListModel, int typeView) {
        this.ListModels = ListModel;
        this.itemView = typeView;
        //this.contentModels = contentModels;

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
        if (itemView == LISTlist) {
            ItemQuranListBinding listBinding = DataBindingUtil
                    .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_quran_list, parent, false);
            return new ViewHolder(listBinding);

            //Hadeth List
        } else if (itemView == GIRDlist) {
            ItemHadethListBinding gridbinding = DataBindingUtil
                    .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_hadeth_list, parent, false);
            return new ViewHolder(gridbinding);
//
//        }else if (itemView == CONTENT) {
//            ItemContentBinding contentBinding = DataBindingUtil
//                    .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_content ,parent, false);
//            return new ViewHolder(contentBinding);

            // default for Quran items
        } else {
            ItemQuranListBinding listBinding = DataBindingUtil.
                    inflate(LayoutInflater.from(parent.getContext()), R.layout.item_quran_list, parent, false);
            return new ViewHolder(listBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        String listModel = ListModels[position];

//      ArrayList<contentModel> contentModels = new ArrayList<contentModel>();

        //Quran
        if (itemView == LISTlist) {
            holder.listBinding.tvSorhName.setText(ListModels[position]);

            //Hadeth
        } else if (itemView == GIRDlist) {
            holder.gridBinding.tvHadethName.setText(ListModels[position]);
        }

        // ************* //Content **************
//        else if(itemView == CONTENT){
//        holder.contentBinding.tvContent.setText((CharSequence) contentModels.get(position));
//    }


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
        if (ListModels == null) {
            return 0;
        } else {

            return ListModels.length;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ItemQuranListBinding listBinding;
        ItemHadethListBinding gridBinding;
//      ItemContentBinding contentBinding;

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

        //content
//        public ViewHolder(ItemContentBinding contentBinding) {
//            super(contentBinding.getRoot());
//            this.contentBinding = contentBinding; }
    }


    //interface for each item
    public interface OnItemClickedListener {
        void onItemClick(int position, String[] ListModels);
    }
}

