package com.example.server2.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface downloadMapper {
    public String getName(String account);
}
