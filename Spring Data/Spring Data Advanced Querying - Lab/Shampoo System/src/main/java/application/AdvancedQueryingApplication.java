package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AdvancedQueryingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AdvancedQueryingApplication.class, args);
        context.close();
    }
}
