package com.luban;

public class User {
    int uid;
    String info;

    public User() {
    }

    public User(int uid, String info) {
        this.uid = uid;
        this.info = info;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
