package com.example.springmvc.handler;

import com.example.springmvc.convent.PropertiesHttpMessageConvent;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/22
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */

public class PropertiesHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        //判断方法返回值类型是否和Properties符合
        return Properties.class.equals(returnType.getMethod().getReturnType());
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {


        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;

        HttpServletRequest request = servletWebRequest.getRequest();


        String header = request.getHeader("Content-Type");

        MediaType mediaType = MediaType.parseMediaType(header);

        Properties properties = (Properties) returnValue;
        PropertiesHttpMessageConvent propertiesHttpMessageConvent = new PropertiesHttpMessageConvent();

        HttpServletResponse response = servletWebRequest.getResponse();

        propertiesHttpMessageConvent.write(properties, mediaType, new ServletServerHttpResponse(response));

    }
}
