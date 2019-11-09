package com.example.springbootlearn.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;
import java.util.Optional;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/16
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(ConditionOnSystemProperty.class.getName());
        Map<String, Object> attrs = metadata.getAnnotationAttributes(ConditionOnSystemProperty.class.getName());


        if (attrs != null) {

            String name = String.valueOf(attrs.get("name"));

            String value = String.valueOf(attrs.get("value"));

            String property = Optional.ofNullable(System.getProperty(name))
                    .orElse("yh");

            return value.equals(property);
        }
        return true;
    }
}
