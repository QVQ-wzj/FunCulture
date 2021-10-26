package com.ram.funculture;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ram.*.mapper")//扫包
public class FunCultureApplication {
    public static void main(String[] args) {
        SpringApplication.run(FunCultureApplication.class, args);
    }

}
