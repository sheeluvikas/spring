package com.example.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This spring main class creates a table in the database from a csv file.
 *
 */
public class CSVTableMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("CSVTableContext.xml");

    }
}
