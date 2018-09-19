package com.zaynchen.mybatispagehelper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@MapperScan(basePackages = "com.zaynchen.mybatispagehelper")
public class MybatisPagehelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPagehelperApplication.class, args);
    }

}
