package com.example.server2;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

@SpringBootTest(properties = "workerClassName=A")
class SpringbootJhApplicationTests {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() throws Exception {
        System.out.println("获取的数据库连接为:"+dataSource.getConnection());
        Integer i = jdbcTemplate.queryForObject("SELECT count(*) from `userimage`", Integer.class);
        System.out.println("user 表中共有" + i + "条数据。");
    }


}
