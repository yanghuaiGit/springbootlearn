package com.example.springbootlearn.bootstrap;

import com.example.springbootlearn.repository.MyFirstLevelRepository;
import com.example.springbootlearn.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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


@SpringBootApplication(scanBasePackages = "com.example.springbootlearn.service")
public class CalculateBootStrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = new SpringApplicationBuilder(CalculateBootStrap.class)
                .web(WebApplicationType.NONE)
                .profiles("java8")
//                .profiles("java7")
                .run(args);

        CalculateService calculateService = configurableApplicationContext.getBean( CalculateService.class);
        calculateService.sum(1,2,3,43);

        configurableApplicationContext.close();
    }
}
