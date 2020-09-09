package com.spring.batch.config;

import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchJobCofiguration {

    // this contains the beans
    // for job builder factory, job repository, job luancher, and step builder factory

    @Bean
    public JobRepository jobRepository() throws Exception {
        MapJobRepositoryFactoryBean factoryBean = new MapJobRepositoryFactoryBean();
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Bean
    public JobBuilderFactory jobBuilderFactory(JobRepository jobRepository){
        return new JobBuilderFactory(jobRepository);
    }

    @Bean
    public JobLauncher jobLauncher(JobRepository jobRepository){
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository(jobRepository);
        return launcher;
    }

    @Bean
    public StepBuilderFactory stepBuilderFactory(JobRepository jobRepository){
        return  new StepBuilderFactory(jobRepository, new ResourcelessTransactionManager());
    }
}
