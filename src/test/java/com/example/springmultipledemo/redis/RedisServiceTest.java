package com.example.springmultipledemo.redis;

import com.example.springmultipledemo.SpringMultipleDemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringMultipleDemoApplication.class)
public class RedisServiceTest {
    @Autowired
    RedisService redisService;


    @Test
    public void testRedis() throws Exception {
        redisService.testRedis();
//        System.out.println(redisService.testRedis());
    }
}