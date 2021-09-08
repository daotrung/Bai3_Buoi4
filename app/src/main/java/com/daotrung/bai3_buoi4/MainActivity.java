package com.daotrung.bai3_buoi4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvFolder ;
    ArrayList<MyFolder> arrayList;
    MyFolderAdapter adapter;
    TextView mTitle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // toolbar
        Toolbar toolbar_demo = findViewById(R.id.toolbar);
        mTitle = findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar_demo);

        mTitle.setText(toolbar_demo.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        rvFolder = findViewById(R.id.rvFolder);
        arrayList = new ArrayList<>();
        arrayList.add(new MyFolder(R.drawable.icon_file,"Video",R.drawable.pencil_icon,R.drawable.remove_icon));
        arrayList.add(new MyFolder(R.drawable.icon_file,"Android",R.drawable.pencil_icon,R.drawable.remove_icon));
        arrayList.add(new MyFolder(R.drawable.icon_file,"Applock",R.drawable.pencil_icon,R.drawable.remove_icon));
        arrayList.add(new MyFolder(R.drawable.icon_file,"Books",R.drawable.pencil_icon,R.drawable.remove_icon));
        arrayList.add(new MyFolder(R.drawable.icon_file,"Map",R.drawable.pencil_icon,R.drawable.remove_icon));
        arrayList.add(new MyFolder(R.drawable.icon_file,"Authenticate Using Google...",R.drawable.pencil_icon,R.drawable.remove_icon));
        arrayList.add(new MyFolder(R.drawable.icon_file,"New folder",R.drawable.pencil_icon,R.drawable.remove_icon));
        arrayList.add(new MyFolder(R.drawable.icon_file,"New folder 1",R.drawable.pencil_icon,R.drawable.remove_icon));
        arrayList.add(new MyFolder(R.drawable.icon_file,"Picture",R.drawable.pencil_icon,R.drawable.remove_icon));
        arrayList.add(new MyFolder(R.drawable.icon_file,"Image",R.drawable.pencil_icon,R.drawable.remove_icon));
        arrayList.add(new MyFolder(R.drawable.icon_file,"Music",R.drawable.pencil_icon,R.drawable.remove_icon));
        adapter = new MyFolderAdapter(arrayList,this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rvFolder.setAdapter(adapter);
        rvFolder.setLayoutManager(linearLayoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         switch (item.getItemId()){
             case R.id.imgAdd:
                 xuLyDialog();
             return true;
             default:
                 return super.onOptionsItemSelected(item);
         }

    }
    public void xuLyDialog(){
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.update_lay);
        EditText edtFolder = dialog.findViewById(R.id.edtFolder);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "";
                if(!edtFolder.getText().toString().equals("")) {
                    name = edtFolder.getText().toString();
                }else{
                    Toast.makeText(MainActivity.this, "Please enter file name", Toast.LENGTH_SHORT).show();
                }
                arrayList.add(new MyFolder(R.drawable.icon_file,name,R.drawable.pencil_icon,R.drawable.remove_icon));
                adapter.notifyItemInserted(arrayList.size()-1);
                rvFolder.scrollToPosition(arrayList.size()-1);
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}