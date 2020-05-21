package com.example.bean;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public class Student {

    //rollnumber : school id, std, number
    // for example : 12, 08, 23 : 120823
    private Integer rollNumber;
    private String name;
    private Date dob;

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
