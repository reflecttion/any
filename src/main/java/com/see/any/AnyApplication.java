package com.see.any;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.see.any.dao.mapper")
public class AnyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnyApplication.class, args);
    }

}
