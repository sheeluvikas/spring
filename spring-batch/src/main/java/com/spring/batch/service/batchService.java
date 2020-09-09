package com.spring.batch.service;

import com.opencsv.CSVReader;
import com.spring.bean.Student;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class batchService {

    public Student[] readFromCSV(String file) throws IOException {
        FileReader reader = new FileReader(file);
        return null; /** TODO : add the code here to read the csv and store it into the Student object*/
    }
}
