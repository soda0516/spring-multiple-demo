package com.example.springmultipledemo.wxminipay;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Describe TODO
 * @Author orang
 * @Create 2019/1/18 11:44
 **/
public class WxMiniToHexString {
    public static String md5(UnifiedOrder unifiedOrder){
        StringBuilder builder = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = messageDigest.digest((unifiedOrder.toStringForSign()+"&key=3071cbc504a24aa1b4f6ae9aee17f2e7").getBytes());
            String tmp = null;
            for (byte b:bytes
                 ) {
                tmp = Integer.toHexString(0xFF & b);
                builder.append(tmp);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return builder.toString().toUpperCase();
    }
}
