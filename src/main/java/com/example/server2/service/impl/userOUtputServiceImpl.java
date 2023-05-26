package com.example.server2.service.impl;

import com.example.server2.entity.userOutput;
import com.example.server2.mapper.userOutputMapper;
import com.example.server2.service.userOutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userOUtputServiceImpl implements userOutputService {
    @Autowired
    private userOutputMapper outputMapper;
    @Override
    public boolean updatePath(String path,String account){
        return outputMapper.updatePath(path,account);
    }
    @Override
    public userOutput queryPath(String account){
        return outputMapper.queryPath(account);
    }
}
