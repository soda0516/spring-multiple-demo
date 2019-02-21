package com.example.springmultipledemo.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.InputMismatchException;

/**
 * @Describe TODO
 * @Author orang
 * @Create 2019/1/5 20:37
 **/
@RestController
@RequestMapping("/oss")
public class Client {
    String endpoint = "https://oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    String accessKeyId = "LTAI421U6cYUequG";
    String accessKeySecret = "yD86OPi5sHIq9jliqmkmFFggCH6P24";
    String bucketName = "loongwine";
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file){
        String fileName = file.getOriginalFilename();
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            ossClient.putObject(bucketName,fileName,new ByteArrayInputStream(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        URL url = ossClient.generatePresignedUrl(bucketName,fileName,expiration);
        System.out.println(String.valueOf(url).replace(url.getHost(),"oss.loveorange.top"));
        System.out.println(url.getHost());
        ossClient.shutdown();
        return file.getOriginalFilename();
    }
    public static void main(String[] args) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI421U6cYUequG";
        String accessKeySecret = "yD86OPi5sHIq9jliqmkmFFggCH6P24";
        String bucketName = "loongwine";
        String objectName = "first-iamge";
// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

// 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
//        String content = "Hello OSS Oss";
        try (
                InputStream content = new FileInputStream("F:/Pictures/20180907103116.jpg")
        ) {
            ossClient.putObject(bucketName, objectName, new File("F:/Pictures/20180907103116.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        OSSObject ossObject = ossClient.getObject(bucketName,objectName);
        try (
                InputStream inputStream = ossObject.getObjectContent();
        ) {
            if (inputStream != null){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while (bufferedReader.ready()){
                    stringBuilder.append(bufferedReader.readLine());
                }
                System.out.println(stringBuilder.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

// 关闭OSSClient。
        ossClient.shutdown();
    }
}
