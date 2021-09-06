package com.daotrung.bai3_buoi4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvFolder ;
    ArrayList<MyFolder> arrayList;
    MyFolderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}