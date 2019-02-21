package com.example.springmultipledemo.common;

import lombok.Data;

/**
 * @Describe
 * @Author orang
 * @Create 2019/2/13 15:39
 **/
@Data
public class ResponseModel<T> {
    private int code;
    private T body;
}
