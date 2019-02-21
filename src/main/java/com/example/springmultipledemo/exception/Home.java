package com.example.springmultipledemo.exception;

import com.example.springmultipledemo.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Task TODO
 * @Describe
 * @Author orang
 * @Create 2019/1/25 21:03
 **/
@RestController
@RequestMapping("/exception")
public class Home {
    @Autowired
    RedisService redisService;
    @GetMapping("")
    public String index() throws Exception{
        redisService.testRedis();
        return null;
    }
}
