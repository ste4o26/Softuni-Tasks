package com.ste4o.user_system.controllers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class UserSystemController implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hi");
    }
}
