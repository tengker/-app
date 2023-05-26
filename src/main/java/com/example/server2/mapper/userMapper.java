package com.example.server2.mapper;

import com.example.server2.entity.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper {
    user findUserByAccount(String account);
    boolean insertUser(String account, String password);
    boolean modifyPassword(String account,String password);
}
