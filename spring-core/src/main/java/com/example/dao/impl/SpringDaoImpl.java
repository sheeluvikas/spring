package com.example.dao.impl;

import com.example.bean.Student;
import com.example.dao.intf.SpringDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SpringDaoImpl implements SpringDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Student student) {

        String insertSql = "insert into student (rollnumber, name, dob) values (?, ?, ?)";
        Date d = new Date();
        Object[] params = new Object []{ student.getRollNumber(),
                student.getName(),
                new java.sql.Date(student.getDob().getTime())};
        jdbcTemplate.update(insertSql, params);
    }

    public Student getStudentByRollNumber(Integer rollnumber) {
        String sql = "select rollnumber, name, dob from student where rollnumber = ?";
        Object[] params = new Object[]{rollnumber};
        Student student = (Student)jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper(Student.class));
        return student;
    }
}
