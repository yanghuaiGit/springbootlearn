package com.example.springmvc.controller;

import com.example.springmvc.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/19
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */

@RestController
public class Test {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {
        request.setAttribute("name", name);
        return "hello";
    }

    @PostMapping("/user")
    public User user(@RequestBody User user) {

        return user;
    }

    /**
     * Convent转换
     *
     * @param properties
     * @return
     */
    @PostMapping(value = "/properties", consumes = "aaa/properties;charset=UTF-8"//过滤媒体类型
//            ,produces = "aaa/properties;charset=UTF-8"
    )
    public Properties properties(@RequestBody Properties properties) {

        return properties;
    }

    /**
     * ArgumentArgs操作
     *
     * @param properties
     * @return
     */
    @PostMapping(value = "/properties1", consumes = "aaa/properties;charset=UTF-8"//过滤媒体类型
//            ,produces = "aaa/properties;charset=UTF-8"
    )
    public Properties properties1(Properties properties) {

        return properties;
    }

    @RequestMapping( value = "/propertiesHandler", consumes = "aaa/properties;charset=UTF-8"//过滤媒体类型
//            ,produces = "aaa/properties;charset=UTF-8"
    )
    public Properties propertiesHandler(Properties properties) {

        return properties;
    }
}
