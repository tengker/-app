package com.example.server2.mapper;

import com.example.server2.entity.userOutput;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userOutputMapper {
    boolean updatePath(String path,String account);
    userOutput queryPath(String account);
}
