package com.example.testcontactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    Context context;
    ArrayList<ContactModel> contactModelList;

    public ContactAdapter(Context context, ArrayList<ContactModel> contactModelList) {
        this.context = context;
        this.contactModelList = contactModelList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Gán data vào view
        ContactModel contactModel = contactModelList.get(position);
        holder.txtName.setText(contactModel.getName());
        holder.txtNumber.setText(contactModel.getPhone());
        if (contactModel.getAvatar() != null) {
            holder.imgAvatar.setImageBitmap(contactModel.getAvatar());
        } else {
            holder.imgAvatar.setImageResource(R.drawable.iphone_11);
        }
    }

    @Override
    public int getItemCount() {
        return contactModelList.size(); //trả item tại position
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView txtName, txtNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ view
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            txtName = itemView.findViewById(R.id.txtName);
        }
    }
}
