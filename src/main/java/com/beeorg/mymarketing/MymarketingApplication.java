package com.beeorg.mymarketing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class MymarketingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MymarketingApplication.class, args);
    }
}