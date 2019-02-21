package com.example.springmultipledemo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @Task TODO
 * @Describe
 * @Author orang
 * @Create 2019/1/25 21:07
 **/
@ControllerAdvice
public class AllControllerAdvice {
    @ResponseBody
    @ExceptionHandler(value = IOException.class)
    public void handler(IOException e){
        System.out.println("跑出异常错误"+this.getClass()+e.getMessage());
        System.out.println("哈哈哈，后面的代码还能执行");
    }
}
