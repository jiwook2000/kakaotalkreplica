package com.example.kakaotalkreplica;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaDataSource;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ChattingActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference myRef;

    EditText EditText_Message;
    String id;


    LinearLayout menu;
    Animation leftAnimation;
    Animation rightAnimation;
    boolean isPageOpen=false;

    ArrayList<ChatData> myDataset = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        Intent intent = getIntent();
        id = intent.getExtras().getString("id");

        EditText_Message=findViewById(R.id.EditText_Message);



        myDataset = new ArrayList<>();


        recyclerView = findViewById(R.id.RecyclerView_Chatting);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        Button buttonSend = findViewById(R.id.Button_Send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatData chatData = new ChatData();
                chatData.setMsg(EditText_Message.getText().toString());
                chatData.setNick("a");
                myRef.push().setValue(chatData);
                EditText_Message.setText("");
            }
        });

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter1(myDataset);
        recyclerView.setAdapter(mAdapter);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ChatData chat = dataSnapshot.getValue(ChatData.class);
                ((MyAdapter1)mAdapter).addChat(chat);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        menu = findViewById(R.id.LinearLayout_Menu);
        leftAnimation= AnimationUtils.loadAnimation(this,R.anim.left_translate);
        rightAnimation=AnimationUtils.loadAnimation(this,R.anim.right_translate);
        Button buttonMenu = findViewById(R.id.Button_Menu);
        buttonMenu.setOnClickListener(new View.OnClickListener() {
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
