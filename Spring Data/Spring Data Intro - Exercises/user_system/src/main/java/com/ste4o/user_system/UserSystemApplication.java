package com.ste4o.user_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UserSystemApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UserSystemApplication.class, args);
        context.close();
    }

}
