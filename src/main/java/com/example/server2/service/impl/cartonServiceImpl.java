package com.example.server2.service.impl;

import com.example.server2.mapper.animalMapper;
import com.example.server2.service.cartonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cartonServiceImpl implements cartonService {
    @Autowired
    private animalMapper animalMapper;
    @Override
    public String queryResult(String account){
        return animalMapper.queryResult(account);
    }
}
