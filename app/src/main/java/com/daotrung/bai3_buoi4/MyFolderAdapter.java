package com.daotrung.bai3_buoi4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyFolderAdapter extends  RecyclerView.Adapter<MyFolderAdapter.MyViewHolder>{
    private List mFolders ;
    private Context mContext ;

    public MyFolderAdapter(List mFolders, Context mContext) {
        this.mFolders = mFolders;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_dong,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyFolder myFolder = (MyFolder) mFolders.get(position);
        holder.imgFile.setImageResource(myFolder.imgFile);
        holder.imgEdit.setImageResource(myFolder.imgEdit);
        holder.imgRemove.setImageResource(myFolder.imgRemove);
        holder.txtTitle.setText(myFolder.txtTitle);

    }

    @Override
    public int getItemCount() {
        return mFolders.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFile ;
        private ImageView imgRemove ;
        private TextView txtTitle ;
        private  ImageView imgEdit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFile = itemView.findViewById(R.id.img_File);
            imgEdit = itemView.findViewById(R.id.imgEdit);
            imgRemove = itemView.findViewById(R.id.imgRemove);
            txtTitle = itemView.findViewById(R.id.txtTitle);

        }
    }
}

