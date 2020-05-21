package com.example.dao.intf;

import com.example.bean.Student;

public interface SpringDao {

    void save(Student student);

    Student getStudentByRollNumber(Integer rollnumber);
}
