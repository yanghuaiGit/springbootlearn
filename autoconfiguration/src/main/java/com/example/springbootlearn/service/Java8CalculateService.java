package com.example.springbootlearn.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/16
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Service
@Profile("java8")
public class Java8CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("java8 实现");

        return Arrays.stream(values)
                .reduce(0, Integer::sum);
    }
}
