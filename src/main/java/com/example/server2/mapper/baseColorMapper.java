package com.example.server2.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface baseColorMapper {
    public String queryPath(String account);
}
