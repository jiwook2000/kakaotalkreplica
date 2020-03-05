package com.example.kakaotalkreplica;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment1 extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

   ArrayList<ChatData> myDataset;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootVIew = (ViewGroup) inflater.inflate(R.layout.fragment1,container,false);

        ArrayList<ChatData> myDataset;
        myDataset=new ArrayList<>();
        for(int i=0;i<50;i++) {

            myDataset.add(new ChatData());
            myDataset.get(i).setNick("홍길동"+(i+1));
            myDataset.get(i).setMsg("ㄴr는...가끔 눈물을 흘린ㄷr....");
        }
        recyclerView = rootVIew.findViewById(R.id.RecyclerView_ChatScreen);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter1(myDataset);
        recyclerView.setAdapter(mAdapter);

        return rootVIew;


    }
}
