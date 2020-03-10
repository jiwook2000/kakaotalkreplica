package com.example.kakaotalkreplica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ChattingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    LinearLayout menu;
    Animation leftAnimation;
    Animation rightAnimation;
    boolean isPageOpen=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        ArrayList<ChatData> myDataset = new ArrayList<>();
        for(int i=0;i<50;i++) {

            myDataset.add(new ChatData());

        }
        recyclerView = findViewById(R.id.RecyclerView_Chatting);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter1(myDataset);
        recyclerView.setAdapter(mAdapter);

        menu = findViewById(R.id.LinearLayout_Menu);
        leftAnimation= AnimationUtils.loadAnimation(this,R.anim.left_translate);
        rightAnimation=AnimationUtils.loadAnimation(this,R.anim.right_translate);
        Button button = findViewById(R.id.Button_Menu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPageOpen) {
                    menu.startAnimation(rightAnimation);
                    isPageOpen=false;
                }else{
                    menu.startAnimation(leftAnimation);
                    menu.setVisibility(View.VISIBLE);
                    isPageOpen=true;
                }
            }
        });



    }
}
