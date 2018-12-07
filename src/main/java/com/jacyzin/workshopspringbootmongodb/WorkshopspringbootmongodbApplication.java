package com.jacyzin.workshopspringbootmongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class WorkshopspringbootmongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkshopspringbootmongodbApplication.class, args);
    }
}
