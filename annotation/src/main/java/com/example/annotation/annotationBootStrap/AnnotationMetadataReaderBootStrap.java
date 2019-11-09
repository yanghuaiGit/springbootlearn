package com.example.annotation.annotationBootStrap;

import com.example.annotation.annotation.TransactionalService;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;
import java.util.Set;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/26
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@TransactionalService
public class AnnotationMetadataReaderBootStrap {
    public static void main(String[] args) throws IOException {
        String className = AnnotationMetadataReaderBootStrap.class.getName();

        //构建MetadataReaderFactory实例
        CachingMetadataReaderFactory cachingMetadataReaderFactory = new CachingMetadataReaderFactory();


        //读取 @TransactionalService MetadataReader信息
        MetadataReader metadataReader = cachingMetadataReaderFactory.getMetadataReader(className);

        //读取 @SecondRepository AnnotationMetadata信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        annotationMetadata.getAnnotationTypes().forEach(annotationType -> {

            Set<String> metaAnnotationTypes = annotationMetadata.getMetaAnnotationTypes(annotationType);

            for (String metaAnnotationType : metaAnnotationTypes) {
                System.out.printf("注解 @%s 元注解 @%s\n", annotationType, metaAnnotationType);
            }
        });

    }
}
