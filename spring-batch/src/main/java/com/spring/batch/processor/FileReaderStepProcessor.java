package com.spring.batch.processor;

import com.spring.bean.Student;
import org.springframework.batch.item.ItemProcessor;

public class FileReaderStepProcessor implements ItemProcessor<Student, Student[]> {


    public Student[] process(Student student) throws Exception {
        return new Student[0];
    }
}
