package com.example.testcontactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {
    ArrayList<StoryModel> storyModels;
    Context context;

    public StoryAdapter( Context context,ArrayList<StoryModel> storyModels) {
        this.storyModels = storyModels;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout_story, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoryModel storyModel = storyModels.get(position);
        holder.txtStoryNumber.setText(storyModel.getContactNumber());
        holder.txtStartTime.setText(storyModel.getStartTime());
        holder.txtTotalTime.setText(storyModel.getTotalTime());
    }


    @Override
    public int getItemCount() {
        return storyModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtStoryNumber, txtTotalTime, txtStartTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtStoryNumber = itemView.findViewById(R.id.txtStoryNumber);
            txtTotalTime = itemView.findViewById(R.id.txtTotalTime);
            txtStartTime = itemView.findViewById(R.id.txtStartTime);
        }
    }
}
