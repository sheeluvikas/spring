package com.example.spring;

import com.example.bean.Student;
import com.example.bean.Teacher;
import com.example.dao.intf.SpringDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * This is the example which explains the usage of spring core.
 *
 */
public class SpringCoreMain {

    public static void main(String[] args) {
        // 1. Read the data from the sample csv
        // 2. Read the data from the reference table
        // 3. stores the data into the table with enriched data from reference table
        // 4. sends the data in the form of csv via queue :: * Later *

        // gets the application context
        // creates a bean to read the csv file
        // create a bean for data source
        // stores the data into the table using named jdbc template
        // * rest later *

        /** https://www.baeldung.com/spring-classpathxmlapplicationcontext */
        //TODO: to read : https://stackoverflow.com/questions/10037450/what-is-the-difference-between-spring-context-and-spring-core-dependencies
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Student student = (Student) context.getBean("student");
        student.setName("Vikas");
        Random random = new Random();
        student.setRollNumber(random.nextInt(9999999));
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.set(2010, 04, 12);
        student.setDob(c.getTime());
        SpringDao springDao = (SpringDao)context.getBean("springDaoImpl");
//        springDao.save(student); // TODO : Uncomment when you need to save the details

        Teacher teacher = (Teacher) context.getBean("teacher");
        System.out.println("Teacher Name : " + teacher.getName());


        System.out.println("The Student Details for the given Id : ");
        Student student1 = springDao.getStudentByRollNumber(120832);
        System.out.println("Roll Number : " + student1.getRollNumber());
        System.out.println("Name : " + student1.getName());
        System.out.println("DOB :" + student1.getDob());
    }
}
