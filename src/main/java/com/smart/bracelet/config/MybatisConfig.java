package com.smart.bracelet.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author junyunxiao
 * @version 1.0
 * @date 2020/6/13 21:09
 * @description 描述信息
 */
@Configuration
@MapperScan(basePackages = {"com.smart.bracelet.dao"})
public class MybatisConfig {
}
