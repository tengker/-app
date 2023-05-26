package com.example.server2.service;

public interface downloadService {
    public byte[] imageToBytes(String account);
    public String queryName(String account);
}
