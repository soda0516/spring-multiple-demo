package com.example.springmultipledemo.redis;

/**
 * @Describe TODO
 * @Author orang
 * @Create 2019/1/1 21:06
 **/
public class Cat {
    public String getName() {
        return name;
    }

    public Cat setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Cat setAge(int age) {
        this.age = age;
        return this;
    }

    private String name;
    private int age;
}
