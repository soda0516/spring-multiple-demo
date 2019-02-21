package com.example.springmultipledemo.wxminipay;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Describe TODO
 * @Author orang
 * @Create 2019/1/18 10:00
 **/
@Data
public class UnifiedOrder {
    private String appid;
    private String attach;
    private String body;
    private String mch_id;
    private String detail;
    private String nonce_str;
    private String notify_url;
    private String openid;
    private String out_trade_no;
    private BigDecimal total_fee;
    private String trade_type;
    private String sign;
    private String sign_type;

    public UnifiedOrder buildUnifiedOrder(){
        this.appid = "wx761947d36ac388b0";
        this.attach="腾蛟红酒";
        this.mch_id = "1522995251";
        this.notify_url = "http://www.weixin.qq.com/wxpay/pay.php";
        this.trade_type = "JSAPI";
        this.sign_type = "MD5";
//        http://www.weixin.qq.com/wxpay/pay.php
        this.nonce_str = UUID.randomUUID().toString().replaceAll("-","");
        this.sign = WxMiniToHexString.md5(this);
        return this;
    }
    public String toStringForSign(){
        return "appid="+this.getAppid()+"&body=test"+this.body+"&mch_id="+this.getMch_id()+"&nonce_str="+this.getNonce_str();
    }
//    <xml>
//   <appid>wx2421b1c4370ec43b</appid>
//   <attach>支付测试</attach>
//   <body>JSAPI支付测试</body>
//   <mch_id>10000100</mch_id>
//   <detail><![CDATA[{ "goods_detail":[ { "goods_id":"iphone6s_16G", "wxpay_goods_id":"1001", "goods_name":"iPhone6s 16G", "quantity":1, "price":528800, "goods_category":"123456", "body":"苹果手机" }, { "goods_id":"iphone6s_32G", "wxpay_goods_id":"1002", "goods_name":"iPhone6s 32G", "quantity":1, "price":608800, "goods_category":"123789", "body":"苹果手机" } ] }]]></detail>
//   <nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>
//   <notify_url>http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php</notify_url>
//   <openid>oUpF8uMuAJO_M2pxb1Q9zNjWeS6o</openid>
//   <out_trade_no>1415659990</out_trade_no>
//   <spbill_create_ip>14.23.150.211</spbill_create_ip>
//   <total_fee>1</total_fee>
//   <trade_type>JSAPI</trade_type>
//   <sign>0CB01533B8C1EF103065174F50BCA001</sign>
//</xml>
}
