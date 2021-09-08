package com.daotrung.bai3_buoi4;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MyFolder myFolder = (MyFolder) mFolders.get(position);
        holder.imgFile.setImageResource(myFolder.getImgFile());
        holder.imgEdit.setImageResource(myFolder.getImgEdit());
        holder.imgRemove.setImageResource(myFolder.getImgRemove());
        holder.txtTitle.setText(myFolder.txtTitle);

        // edit

        // edit
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(mContext);
                dialog.setContentView(R.layout.update_lay);

                EditText edtUpdate = dialog.findViewById(R.id.edtFolder);
                Button btnEdt = dialog.findViewById(R.id.btnAdd);
                TextView txtTitle = dialog.findViewById(R.id.txtTitleDialog);

                btnEdt.setText("Update");
                txtTitle.setText("Update File");
                edtUpdate.setText(((MyFolder) mFolders.get(position)).txtTitle);
                btnEdt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String fileName = "";
                        if (!edtUpdate.getText().toString().equals("")) {
                            fileName = edtUpdate.getText().toString();
                        }else{
                            Toast.makeText(mContext, "Please enter file name ", Toast.LENGTH_SHORT).show();
                        }

                        mFolders.set(position,new MyFolder(R.drawable.icon_file,fileName,R.drawable.pencil_icon,R.drawable.remove_icon));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
        // delete
       holder.imgRemove.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               AlertDialog.Builder builder = new AlertDialog.Builder(mContext)
                       .setTitle("Delete Contact")
                       .setMessage("Are you sure want to delete ? ")
                       .setIcon(R.drawable.ic_baseline_delete_24)
                       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               mFolders.remove(position);
                               notifyItemRemoved(position);
                           }
                       })
                       .setNegativeButton("No", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {

                           }
                       });
               builder.show();
           }
       });

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

