package com.example.springmultipledemo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe TODO
 * @Author orang
 * @Create 2019/1/1 19:01
 **/
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
//    @Autowired
//    RedisService redisService;
    @GetMapping("")
    public String index() throws Exception{
        Cat cat = new Cat();
        cat.setName("咪咪");
        List<Object> list = new ArrayList<>();
        list.add(cat);
        list.add(cat);
        redisTemplate.opsForValue().set("catList",list);
        for (Cat c:(List<Cat>)redisTemplate.opsForValue().get("catList")
             ) {
            System.out.println(c.getName());
        }
        return null;
//        return redisService.testRedis();
    }
}
