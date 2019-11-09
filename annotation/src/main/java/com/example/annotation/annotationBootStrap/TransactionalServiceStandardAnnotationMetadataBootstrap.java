/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.annotation.annotationBootStrap;

import com.example.annotation.annotation.TransactionalService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * {@link TransactionalService @TransactionalService} {@link StandardAnnotationMetadata}实现 引导类
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since 1.0.0
 */
@TransactionalService
public class TransactionalServiceStandardAnnotationMetadataBootstrap {

    public static void main(String[] args) throws IOException {

        // 读取 @TransactionService AnnotationMetadata 信息
        AnnotationMetadata annotationMetadata = new StandardAnnotationMetadata(TransactionalServiceStandardAnnotationMetadataBootstrap.class);

        // 获取所有的元注解类型（全类名）集合
        Set<String> metaAnnotationTypes = annotationMetadata.getAnnotationTypes()
                .stream() // TO Stream
                .map(annotationMetadata::getMetaAnnotationTypes) // 读取单注解的元注解类型集合
                .collect(LinkedHashSet::new, Set::addAll, Set::addAll); // 合并元注解类型（全类名）集合

//        metaAnnotationTypes.addAll(annotationMetadata.getAnnotationTypes());

        metaAnnotationTypes.forEach(metaAnnotation -> { // 读取所有元注解类型
            // 读取元注解属性信息
            Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(metaAnnotation);
            if (!CollectionUtils.isEmpty(annotationAttributes)) {
                annotationAttributes.forEach((name, value) ->
                        System.out.printf("注解 @%s 属性 %s = %s\n", ClassUtils.getShortName(metaAnnotation), name, value));
            }
        });
    }
}
