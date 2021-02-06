package com.spirng_demo;

import com.spirng_demo.entities.Account;
import com.spirng_demo.entities.User;
import com.spirng_demo.services.interfaces.AccountService;
import com.spirng_demo.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserService userService;
    private AccountService accountService;

    @Autowired
    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
//            this.createUserWithEmptyAccount();
            this.withdrawMoney();
            //TODO implement transferMoney method
        } catch (IOException | IllegalArgumentException ex) {
            System.err.println(String.format("%s with message %s",
                    ex.getClass().getSimpleName(),
                    ex.getMessage()));
        }
    }

    private void createUserWithEmptyAccount() throws IOException, IllegalArgumentException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter username: ");
        String username = reader.readLine();

        System.out.print("Enter age: ");
        int age = Integer.parseInt(reader.readLine());

        User user = new User();
        user.setUsername(username);
        user.setAge(age);

        this.userService.registerUser(user);

        Account account = new Account();
        account.setBalance(BigDecimal.ZERO);
        account.setUser(user);

        this.accountService.createAccount(account);
    }

    private void withdrawMoney() throws IOException, IllegalArgumentException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //ENTER USERNAME HERE!!!
        System.out.println("Who are you: ");
        String username = reader.readLine();
        User user = this.userService.findUserByUsername(username);

        System.out.print("Enter the amount you want to withdraw: ");
        BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(reader.readLine()));

        System.out.print("Enter id of the account you want to withdraw from: ");
        Long id = Long.parseLong(reader.readLine());

        this.accountService.withdrawMoney(amount, id, user.getId());
    }
}
