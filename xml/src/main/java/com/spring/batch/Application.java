package com.spring.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by with IntelliJ IDEA.
 * User: pradeep
 * Date: 15/2/17
 * Time: 10:17 PM
 */
public class Application {
    public static void main(String[] args) {
        String[] springConfig =
                {
                        "batch.xml"
                };

        ApplicationContext context =
                new ClassPathXmlApplicationContext(springConfig);

        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("csvJob");

        try {

            JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Exit Status : " + execution.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}