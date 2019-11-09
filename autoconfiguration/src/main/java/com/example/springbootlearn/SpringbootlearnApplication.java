package com.example.springbootlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages ="com.example.springbootlearn.web.servlet" )
public class SpringbootlearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootlearnApplication.class, args);
    }

}
