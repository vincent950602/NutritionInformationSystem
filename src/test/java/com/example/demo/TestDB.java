package com.example.demo;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TestDB {

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {

//        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }


}
