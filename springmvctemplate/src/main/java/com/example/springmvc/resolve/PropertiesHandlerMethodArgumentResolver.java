package com.example.springmvc.resolve;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.Properties;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/21
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Properties.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

       ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;

        HttpServletRequest request = servletWebRequest.getRequest();


        String header = request.getHeader("Content-Type");

        MediaType mediaType = MediaType.parseMediaType(header);

        //获取字符编码
        Charset charset = mediaType.getCharset();

        if (Objects.isNull(charset)) {
            charset = Charset.forName("UTF-8");
        }

        //字节流
        InputStream inputStream = request.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);

        Properties properties = new Properties();

        properties.load(inputStreamReader);

        return properties;
    }
}
