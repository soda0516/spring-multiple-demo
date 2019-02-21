package com.example.springmultipledemo.lombok;

import lombok.*;

/**
 * @Describe TODO
 * @Author orang
 * @Create 2019/1/3 10:18
 **/
@Data
@Getter
@Setter
@ToString
public class Dog {
    @NonNull
    private String name;
    @NonNull
    private int age;
    private String type;

}
