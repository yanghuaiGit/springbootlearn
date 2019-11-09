package com.example.springbootlearn.bootstrap;

import com.example.springbootlearn.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/16
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */


@EnableHelloWorld
public class EnableHelloWorldBootStrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = new SpringApplicationBuilder(EnableHelloWorldBootStrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorld = configurableApplicationContext.getBean("helloWorld", String.class);
        System.out.println("------" + helloWorld + "------");

        configurableApplicationContext.close();
    }
}
