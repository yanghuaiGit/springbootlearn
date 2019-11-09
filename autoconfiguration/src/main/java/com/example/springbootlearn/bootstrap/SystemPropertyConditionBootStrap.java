package com.example.springbootlearn.bootstrap;

import com.example.springbootlearn.condition.ConditionOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/16
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */


public class SystemPropertyConditionBootStrap {


    @Bean
    @ConditionOnSystemProperty(name = "user.name", value = "dell")
    public String helloWorld() {
        return "Hello dell";
    }


    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = new SpringApplicationBuilder(SystemPropertyConditionBootStrap.class)
                .web(WebApplicationType.NONE)
                .profiles("java8")
//                .profiles("java7")
                .run(args);

        String helloWorld = configurableApplicationContext.getBean("helloWorld", String.class);

        System.out.println("----" + helloWorld + "---");

        configurableApplicationContext.close();
    }
}
