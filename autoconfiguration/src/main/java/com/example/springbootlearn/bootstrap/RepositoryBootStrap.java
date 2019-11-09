package com.example.springbootlearn.bootstrap;

import com.example.springbootlearn.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/16
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */


@ComponentScan(basePackages = "com.example.springbootlearn.repository")
public class RepositoryBootStrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = new SpringApplicationBuilder(RepositoryBootStrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        MyFirstLevelRepository myFirstLevelRepository = configurableApplicationContext.getBean("myFirstLevelRepository", MyFirstLevelRepository.class);
        System.out.println("------" + myFirstLevelRepository + "------");

        configurableApplicationContext.close();
    }
}
