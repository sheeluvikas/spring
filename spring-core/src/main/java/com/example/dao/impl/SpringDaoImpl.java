package com.example.dao.impl;

import com.example.bean.Student;
import com.example.dao.intf.SpringDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SpringDaoImpl implements SpringDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Student student) {

        String insertSql = "insert into student (name, dob) values (?, ?)";
        Date d = new Date();
        Object[] params = new Object []{ "Vikas", new java.sql.Date(d.getTime())};
        jdbcTemplate.update(insertSql, params);
    }
}
