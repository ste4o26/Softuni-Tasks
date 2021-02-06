package book_shop_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BookShopSystemApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BookShopSystemApplication.class, args);
        context.close();
    }
}
