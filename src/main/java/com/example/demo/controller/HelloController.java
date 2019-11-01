package com.example.demo.controller;

import com.example.demo.entity.Users;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.ui.ModelMap;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@RestController
public class HelloController {

    @RequestMapping("/userlist")
    @ResponseBody
    public List<Users> getUserList(ModelMap map) {
        String sql = "SELECT * FROM user";
        List<Users> userList = jdbcTemplate.query(sql, new RowMapper<Users>() {
            Users user = null;

            public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
                user = new Users();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSex(rs.getString("sex"));
                user.setPhone(rs.getString("phone"));
                return user;
            }
        });
        System.out.println("Id - 姓名 - 性别 - 手机号");
        for (Users user : userList) {
            System.out.println(user.getId() + " - " + user.getName() + " - " + user.getSex() + " - " + user.getPhone());
        }
        map.addAttribute("users", userList);

        return userList;

    }

    @Resource
    private JdbcTemplate jdbcTemplate;
}