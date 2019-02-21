package com.example.springmultipledemo.wxminipay;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.UUID;

/**
 * @Describe TODO
 * @Author orang
 * @Create 2019/1/18 10:43
 **/
public class Client {
    public static void main(String[] args) throws Exception {
//        odPuP4myKjW_iOCW7etVSicTjgsY
//        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//        String stringA="appid=wxd930ea5d5a258f4f&body=test&device_info=1000&mch_id=10000100&nonce_str=ibuaiVcKdpRxkhJA";
//        byte[] bytes = messageDigest.digest(stringA.getBytes());
//        System.out.println(bytToHex(bytes));
        UnifiedOrder unifiedOrder = new UnifiedOrder();
        unifiedOrder.setOpenid("odPuP4myKjW_iOCW7etVSicTjgsY");
        unifiedOrder.setTotal_fee(new BigDecimal(0.1));
        unifiedOrder = unifiedOrder.buildUnifiedOrder();
        String xml = UnifiedOrderXml.generateXml(unifiedOrder);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/pay/unifiedorder");
        httpPost.setHeader("Content-type", "text/xml; charset=utf-8");
        StringEntity entity = new StringEntity(xml, Charset.forName("UTF-8"));
        httpPost.setEntity(entity);
        HttpResponse response = httpClient.execute(httpPost);
        System.out.println(response.getEntity().toString());

    }
    private static String bytToHex(byte[] bytes){
        StringBuilder builder = new StringBuilder();
        String temp = null;
        for (byte b:bytes
             ) {
            temp = Integer.toHexString(0xFF & b);
            if (temp.length() == 1)// 每个字节8为，转为16进制标志，2个16进制位
            {
                temp = "0" + temp;
            }
            builder.append(temp);
        }
        return builder.toString();
    }
}
