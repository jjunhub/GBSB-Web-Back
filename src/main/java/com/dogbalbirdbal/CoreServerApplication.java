package com.dogbalbirdbal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoreServerApplication.class, args);
        System.out.println("Server Start!");
    }
}
