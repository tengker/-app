package com.example.server2.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;

@Mapper
public interface animalMapper {
    public String queryResult(String account);
}
