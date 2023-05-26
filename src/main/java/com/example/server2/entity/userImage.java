package com.example.server2.entity;

public class userImage {
    private int id;
    private String account;
    private String imagname;

    public userImage(int id, String account, String imagname) {
        this.id = id;
        this.account = account;
        this.imagname = imagname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getImagname() {
        return imagname;
    }

    public void setImagname(String imagname) {
        this.imagname = imagname;
    }
}
