package com.example.springbootlearn.bootstrap;

import com.example.springbootlearn.configuration.HelloWorldAutoConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/16
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */


@EnableAutoConfiguration
public class EnableAutoConfigurationBootStrap {


    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = new SpringApplicationBuilder(EnableAutoConfigurationBootStrap.class)
                .web(WebApplicationType.NONE)
                .run(args);


        String helloWorld = configurableApplicationContext.getBean("helloWorld", String.class);
        System.out.println("------" + helloWorld + "------");

        HelloWorldAutoConfiguration helloWorld1 = configurableApplicationContext.getBean(HelloWorldAutoConfiguration.class);
        System.out.println("------" + helloWorld1.getClass().getName() + "------");

        configurableApplicationContext.close();
    }
}
