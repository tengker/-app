package com.example.server2.entity;

public class userOutput {
    private int id;
    private String account;
    private String path;

    public userOutput(String account, String path) {
        this.account = account;
        this.path = path;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
