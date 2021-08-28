package com.alamat.islami.RecyclerViewAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.alamat.islami.R;
import com.alamat.islami.databinding.ItemHadethListBinding;
import com.alamat.islami.databinding.ItemQuranListBinding;

import org.jetbrains.annotations.NotNull;

import static android.media.CamcorderProfile.get;

public class RecyclerViewAdapterLists extends RecyclerView.Adapter<RecyclerViewAdapterLists.ViewHolder> {

    String[] ListModels;
    int typeView;


    // typeView vars
    public static final int LISTlist = 100;
    public static final int GIRDlist = 200;
//    public static final int CONTENT = 300;


    //constructors

    public void setListModels(String[] listModels) {
        ListModels = listModels;
    }

    public String[] getListModels() {
        return ListModels;
    }

    public RecyclerViewAdapterLists(String[] ListModel, int typeView) {
        this.ListModels = ListModel;
        this.typeView = typeView;
    }

    // interfaces

    OnItemClickedListener onItemClickedListener;
    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }


    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

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

//        }else if (typeView == CONTENT) {
//            ItemContentBinding contentBinding = DataBindingUtil
//                    .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_content ,parent, false);
//            return new ViewHolder(contentBinding);

//             default for Quran items
        } else {
            ItemQuranListBinding listBinding = DataBindingUtil.
                    inflate(LayoutInflater.from(parent.getContext()), R.layout.item_quran_list, parent, false);
            return new ViewHolder(listBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String listModel = ListModels[position];
//        ArrayList<String> contentLines = contentLines.get(position);

        //Quran
        if (typeView == LISTlist) {
            holder.listBinding.tvSorhName.setText(ListModels[position]);

            //Hadeth
        } else if (typeView == GIRDlist) {
            holder.gridBinding.tvHadethName.setText(ListModels[position]);

            if (onItemClickedListener != null){
                holder.gridBinding.tvHadethName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickedListener.onItemClick(position, ListModels[position]);
                    }
                });
            }
        }

    // for interface
        if(onItemClickedListener !=null) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickedListener.onItemClick(position, ListModels[position]);
            }
        });
    }

}


    @Override
    public int getItemCount() {


        if ( ListModels == null){
            return 0;
        } else {
            return ListModels.length;
        }

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ItemQuranListBinding listBinding;
        ItemHadethListBinding gridBinding;
//        ItemContentBinding contentBinding;

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
    public interface OnItemClickedListener {
        void onItemClick(int position, String ListModels);
    }

}