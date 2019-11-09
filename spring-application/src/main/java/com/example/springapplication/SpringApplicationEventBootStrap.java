package com.example.springapplication;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring应用事件引导类
 */

public class SpringApplicationEventBootStrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        //注册应用事件监听器
        annotationConfigApplicationContext.addApplicationListener(event -> {
            System.out.println("监听到事件" + event);
        });


        //启动上下文
        annotationConfigApplicationContext.refresh();

        //PayloadApplicationEvent事件
        annotationConfigApplicationContext.publishEvent("hello World");

        annotationConfigApplicationContext.publishEvent(new ApplicationEvent("2019") {

        });

        //关闭上下文
        annotationConfigApplicationContext.close();

    }

}
