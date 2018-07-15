package com.example.nytime.adilehsan.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.nytime.adilehsan.R;
import com.example.nytime.adilehsan.interfaces.RecycleViewItemClick;
import com.example.nytime.adilehsan.models.ResultDataModel;

public class ArticalsResultAdapter extends RecyclerView.Adapter<ArticalsResultAdapter.ArticalsViewHolder>{
    private ArrayList<ResultDataModel> resultDataModels;
    private RecycleViewItemClick recycleViewItemClick;
    public ArticalsResultAdapter(ArrayList<ResultDataModel> resultDataModels,RecycleViewItemClick recycleViewItemClick){
        this.resultDataModels=resultDataModels;
        this.recycleViewItemClick=recycleViewItemClick;
    }
    @Override
    public ArticalsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_row, parent, false);
        return new ArticalsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticalsViewHolder holder, final int position) {
        holder.titleTextView.setText(resultDataModels.get(position).getTitle());
        holder.byTextView.setText(resultDataModels.get(position).getByline());
        holder.nameTextView.setText(resultDataModels.get(position).getSection());
        holder.dateTextView.setText(resultDataModels.get(position).getPublished_date());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recycleViewItemClick.onItemClick(resultDataModels.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultDataModels.size();
    }

    class ArticalsViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView, titleTextView, dateTextView,byTextView;

        ArticalsViewHolder(View itemView) {
            super(itemView);
            nameTextView =  itemView.findViewById(R.id.nameText);
            titleTextView =  itemView.findViewById(R.id.titleText);
            byTextView =  itemView.findViewById(R.id.byText);
            dateTextView =  itemView.findViewById(R.id.dateText);

        }
    }
}
