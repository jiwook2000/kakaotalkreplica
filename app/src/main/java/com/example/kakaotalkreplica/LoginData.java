package com.example.kakaotalkreplica;

import androidx.annotation.Nullable;

public class LoginData {
    private String id;
    private String pw;

    public String getId(){
        return id;
    }
    public String getPw(){
        return pw;
    }
    public void putId(String id){
        this.id=id;
    }
    public void putPw(String pw){
        this.pw=pw;
    }
    public LoginData(String id, String pw){
        this.id=id;
        this.pw=pw;

    }
    public LoginData(){
        this.id="a";
        this.pw="a";
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        boolean sameSame = false;
        if (obj!=null && obj instanceof LoginData){
            sameSame=(this.id.equals(((LoginData)obj).getId()))&&(this.pw.equals(((LoginData)obj).getPw()));
        }

        return sameSame;
    }
}
