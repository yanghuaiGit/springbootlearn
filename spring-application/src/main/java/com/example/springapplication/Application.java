package com.example.springapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(Application.class, args);

        System.out.println("SpringApplicationContext类型" + configurableApplicationContext.getClass().getName());

        System.out.println("SpringApplicationContextEnvironment类型" + configurableApplicationContext.getEnvironment().getClass().getName());


        configurableApplicationContext.close();
    }

}
