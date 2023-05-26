package com.example.server2.service.impl;

import com.example.server2.entity.user;
import com.example.server2.mapper.userMapper;
import com.example.server2.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private userMapper userMapper;
    @Override
    public boolean insertUser(String account, String password){
        return userMapper.insertUser(account, password);
    }
    @Override
    public user queryUser(String account){
        return userMapper.findUserByAccount(account);
    }
    @Override
    public byte[] imgToBytes(String path){
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //可能溢出,简单起见就不考虑太多,如果太大就要另外想办法，比如一次传入固定长度byte[]
        byte[] bytes  = new byte[0];
        try {
            bytes = new byte[fin.available()];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //将文件内容写入字节数组，提供测试的case
        try {
            fin.read(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fin.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bytes;
    }

}
