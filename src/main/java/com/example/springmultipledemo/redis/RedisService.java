package com.example.springmultipledemo.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Describe TODO
 * @Author orang
 * @Create 2019/1/1 19:02
 **/
@Service
public class RedisService {

    @Autowired
    private ObjectMapper jacksonObjectMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public String testRedis() throws Exception{
        List<Object> list = new ArrayList<>();
        Cat cat1 = new Cat();
        cat1.setName("咪咪");
        list.add(cat1);
        list.add(cat1);
        System.out.println(list.size());
//        list.add(new Cat());
        stringRedisTemplate.opsForList().rightPush("list","哈哈");
        return "运行成功！";
    }

}
