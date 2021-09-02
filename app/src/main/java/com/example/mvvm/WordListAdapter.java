package com.example.mvvm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mvvm.database.Model;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ProfileMenuViewHolder> {

    private List<Model> optionList;
    private Context context;


    public WordListAdapter(Context context, List<Model> optionList) {
        this.optionList = optionList;
        this.context = context;
    }

    @NonNull
    @Override
    public WordListAdapter.ProfileMenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item,
                viewGroup, false);
        return new WordListAdapter.ProfileMenuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.ProfileMenuViewHolder holder, int i) {

        holder.titleTV.setText(optionList.get(i).getName());

    }

    @Override
    public int getItemCount() {
        return optionList.size();
    }

    class ProfileMenuViewHolder extends RecyclerView.ViewHolder {


        private TextView titleTV;


        ProfileMenuViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTV = itemView.findViewById(R.id.textView);



        }
    }
    public  void update(List<Model> list)
    {
        this.optionList=list;
        notifyDataSetChanged();

    }
}
