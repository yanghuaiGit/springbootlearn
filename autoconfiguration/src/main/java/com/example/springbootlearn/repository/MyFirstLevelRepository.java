package com.example.springbootlearn.repository;

import com.example.springbootlearn.annotation.FirstLevelRepository;
import com.example.springbootlearn.annotation.SecondRepository;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/16
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@FirstLevelRepository(value = "myFirstLevelRepository")
//@SecondRepository(value = "myFirstLevelRepository")
public class MyFirstLevelRepository {

}
