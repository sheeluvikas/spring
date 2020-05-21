package com.example.spring;

import com.example.bean.Student;
import com.example.bean.Teacher;
import com.example.dao.intf.SpringDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        System.out.println(student.getName());
        student.setName("Vikas");
        System.out.println(student.getName());

        Teacher teacher = (Teacher) context.getBean("teacher");
        System.out.println(teacher.getName());

        SpringDao springDao = (SpringDao)context.getBean("springDaoImpl");
        springDao.save(student);

    }
}
