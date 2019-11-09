package com.example.springmvc.convent;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.Properties;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/20
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class PropertiesHttpMessageConvent extends AbstractGenericHttpMessageConverter<Properties> {

    public PropertiesHttpMessageConvent() {

        super(new MediaType("aaa", "properties"));
    }


    @Override
    protected void writeInternal(Properties properties, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        //Properties变为String
        //OutputStream -> Writer

        //字节输出流
        OutputStream outputStream = outputMessage.getBody();


        HttpHeaders headers = outputMessage.getHeaders();

        MediaType contentType = headers.getContentType();


        //获取字符编码
        Charset charset = contentType.getCharset();

        if (Objects.isNull(charset)) {
            charset = Charset.forName("UTF-8");
        }
        Writer writer = new OutputStreamWriter(outputStream, charset);

        //Properties写入字符输出流
        properties.store(writer,"From PropertiesHttpMessageConvent");



    }

    @Override
    protected Properties readInternal(Class<? extends Properties> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {


        //字符流 -》 字符编码 Content-type解析编码
        HttpHeaders headers = inputMessage.getHeaders();

        MediaType contentType = headers.getContentType();
        //获取字符编码
        Charset charset = contentType.getCharset();

        if (Objects.isNull(charset)) {
            charset = Charset.forName("UTF-8");
        }

        //字节流
        InputStream inputStream = inputMessage.getBody();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);

        Properties properties = new Properties();

        properties.load(inputStreamReader);

        return properties;
    }

    @Override
    public Properties read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(null, inputMessage);
    }
}
