package com.example.dynamicvp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder> {
    private ArrayList<String> tar;
    private int length=0;
    public TextAdapter(ArrayList<String> tar,int length) {
        this.tar = tar;
        Log.e("length",length+"");
        this.length=length;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.recText.setText(tar.get(position));
    }

    @Override
    public int getItemCount() {
        return length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView recText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recText=itemView.findViewById(R.id.rec_text);
        }
    }
}
