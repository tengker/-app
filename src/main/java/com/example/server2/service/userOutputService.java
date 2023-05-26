package com.example.server2.service;

import com.example.server2.entity.userOutput;

public interface userOutputService {
    boolean updatePath(String account,String path);
    userOutput queryPath(String account);
}
