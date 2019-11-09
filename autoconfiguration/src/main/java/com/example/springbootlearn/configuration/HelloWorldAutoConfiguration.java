package com.example.springbootlearn.configuration;

import com.example.springbootlearn.annotation.EnableHelloWorld;
import com.example.springbootlearn.condition.ConditionOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/16
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */

@Configuration//spring模式注解 这个步骤其实是不需要的 因为在spring.factory里已经加载了
@EnableHelloWorld//spring @Enable模块装配
@ConditionOnSystemProperty(name = "user.name", value = "dell")//条件装配
public class HelloWorldAutoConfiguration {

}
