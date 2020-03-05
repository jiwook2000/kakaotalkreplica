package com.example.kakaotalkreplica;

public class ChatData{
    private String nick;
    private String msg;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public ChatData(String nick, String msg) {
        this.nick=nick;
        this.msg=msg;

    }
    public ChatData() {
        this.nick="홍길동";
        this.msg="아버지를 아버지라 부르지 못하고...";

    }
}