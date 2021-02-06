package com.spirng_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    /**
     * 1st task - create the project as well as the application.properties file and the needed packages
     * 2nd task - create database entities(models)
     * 3rd task - create repository interface which extends crud repository for all entities that would be stored int the database
     * 4th task - create service interface for each entity as well as classes which implements those interfaces because
     * the validation and all business logic should be implemented there
     * 5th task - create console runner as well as application classes and inject needed repositories and tag with needed annotations
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        //This close method is needed if i dont want my application to run for ever !!! :D
        applicationContext.close();
    }

}

