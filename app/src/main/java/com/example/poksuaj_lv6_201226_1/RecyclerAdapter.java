package com.example.poksuaj_lv6_201226_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<NameViewHolder> {
    private List<String> dataList = new ArrayList<>();
    private NameButtonClick clickListener;
    public RecyclerAdapter(NameButtonClick listener){
        this.clickListener=listener;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View cellView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_look, parent, false);
        return new NameViewHolder(cellView, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder nameViewHolder, int position){
        nameViewHolder.setName(dataList.get(position));
    }

    @Override
    public int getItemCount(){
        return dataList.size();
    }
    public void addData(List<String> data){
        this.dataList.clear();
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }
    public void addNewCell(String name, int position){
        if(dataList.size()>=position){
            dataList.add(position, name);
            notifyItemInserted(position);
        }
    }
    public void removeCell(int position){
        if(dataList.size()>position){
            dataList.remove(position);
            notifyItemRemoved(position);
        }
    }
}
