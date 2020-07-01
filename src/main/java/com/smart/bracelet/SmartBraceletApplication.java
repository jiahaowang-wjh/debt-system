package com.smart.bracelet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * @author junyunxiao
 * @version 1.0
 * @date 2020/5/20 17:29
 * @description 描述信息
 */
@SpringBootApplication
public class SmartBraceletApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartBraceletApplication.class);
    }

}
