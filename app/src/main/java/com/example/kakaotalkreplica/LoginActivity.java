package com.example.kakaotalkreplica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText editId;
    private EditText editPw;
    ArrayList<LoginData> loginDataset = new ArrayList<>();
    LoginData loginData;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginDataset.add(new LoginData("a","a"));
        loginDataset.add(new LoginData("b","b"));


        editId=findViewById(R.id.editId);
        editPw=findViewById(R.id.editPw);




        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=editId.getText().toString();
                String pw=editPw.getText().toString();
                loginData = new LoginData(id,pw);

                if(loginDataset.contains(loginData)){
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("id",id);
                    intent.putExtra("pw",pw);
                    startActivity(intent);
                } else{
                    Toast.makeText(getApplicationContext(),"id나 pw가 틀렸습니다.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
