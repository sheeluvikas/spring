package com.spring.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JobConfig {

    private JobBuilderFactory jobBuilderFactory;

    @Bean(name="batchJob")
    public Job batchJob(Step initStep, Step fileReaderStep, Step fileLoaderStep){
        return jobBuilderFactory.get("BatchJob")
                .start(initStep)
                .next(fileReaderStep)
                .next(fileLoaderStep).build();
    }
}
