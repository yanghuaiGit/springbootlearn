package com.example.springapplication;

import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring 上下文引导类
 */

@SpringBootApplication
public class SpringApplicationContextBootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootStrap.class)
                .web(WebApplicationType.SERVLET)
                .run(args);

        System.out.println("SpringApplicationContext类型" + context.getClass().getName());

        System.out.println("SpringApplicationContextEnvironment类型" + context.getEnvironment().getClass().getName());


        context.close();


    }

}
