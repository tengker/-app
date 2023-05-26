package com.example.server2.service;

import com.example.server2.entity.user;


public interface userService {
    boolean insertUser(String account, String password);
    user queryUser(String account);
    byte[] imgToBytes(String path);

}
