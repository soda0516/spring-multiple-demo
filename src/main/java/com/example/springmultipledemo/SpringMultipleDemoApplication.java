package com.example.springmultipledemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringMultipleDemoApplication {
    private static Logger logger = LoggerFactory.getLogger(SpringMultipleDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringMultipleDemoApplication.class, args);
        logger.error("测试一下");
    }

}

