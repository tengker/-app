package com.example.server2.service.impl;

import com.example.server2.service.baseColorService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.server2.mapper.baseColorMapper;
import org.springframework.stereotype.Service;

@Service
public class baseColorServiceImpl implements baseColorService {
    @Autowired
    private baseColorMapper baseColorMapper;
    @Override
    public String queryPath(String account) {
        return baseColorMapper.queryPath(account);
    }
}
