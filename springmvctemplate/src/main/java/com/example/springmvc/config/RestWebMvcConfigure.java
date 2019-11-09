package com.example.springmvc.config;

import com.example.springmvc.convent.PropertiesHttpMessageConvent;
import com.example.springmvc.handler.PropertiesHandlerMethodReturnValueHandler;
import com.example.springmvc.resolve.PropertiesHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/20
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Configuration
public class RestWebMvcConfigure implements WebMvcConfigurer {

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //不建议添加到集合末尾
//        converters.add(new PropertiesHttpMessageConvent());
        converters.set(0, new PropertiesHttpMessageConvent());
    }

//    /**
//     * 添加自定义的Resolver的优先级低于内建的实现  即使是使用了set(0) 不建议使用
//     * @param resolvers
//     */
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        if (CollectionUtils.isEmpty(resolvers)) {
//            resolvers.add(new PropertiesHandlerMethodArgumentResolver());
//        } else {
//            resolvers.set(0, new PropertiesHandlerMethodArgumentResolver());
//        }
//    }


    @PostConstruct
    public void init() {
        List<HandlerMethodArgumentResolver> argumentResolvers = requestMappingHandlerAdapter.getArgumentResolvers();
        List<HandlerMethodArgumentResolver> list = new ArrayList<>(argumentResolvers.size() + 1);
        list.add(new PropertiesHandlerMethodArgumentResolver());
        list.addAll(argumentResolvers);

        requestMappingHandlerAdapter.setArgumentResolvers(list);

        List<HandlerMethodReturnValueHandler> returnValueHandlers = requestMappingHandlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> listHandlers = new ArrayList<>(returnValueHandlers.size() + 1);
        listHandlers.add(new PropertiesHandlerMethodReturnValueHandler());
        listHandlers.addAll(returnValueHandlers);
    }
}
