package com.example.springmultipledemo.wxminipay;

/**
 * @Describe TODO
 * @Author orang
 * @Create 2019/1/18 15:17
 **/
public class UnifiedOrderXml {
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
    public static String generateXml(UnifiedOrder unifiedOrder){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<appid>").append(unifiedOrder.getAppid()).append("</appid>");
        stringBuilder.append("<attach>").append(unifiedOrder.getAttach()).append("</attach>");
        stringBuilder.append("<body>").append(unifiedOrder.getBody()).append("</body>");
        stringBuilder.append("<mch_id>").append(unifiedOrder.getMch_id()).append("</mch_id>");
        stringBuilder.append("<detail>").append(unifiedOrder.getDetail()).append("</detail>");
        stringBuilder.append("<nonce_str>").append(unifiedOrder.getNonce_str()).append("</nonce_str>");
        stringBuilder.append("<notify_url>").append(unifiedOrder.getNotify_url()).append("</nonce_str>");
        stringBuilder.append("<openid>").append(unifiedOrder.getOpenid()).append("</openid>");
        stringBuilder.append("<out_trade_no>").append(unifiedOrder.getOut_trade_no()).append("</out_trade_no>");
//        stringBuilder.append("<spbill_create_ip>").append(unifiedOrder.gets).append("</spbill_create_ip>");
        stringBuilder.append("<total_fee>").append(unifiedOrder.getTotal_fee()).append("</total_fee>");
        stringBuilder.append("<trade_type>").append(unifiedOrder.getTrade_type()).append("</trade_type>");
        stringBuilder.append("<sign>").append(unifiedOrder.getSign()).append("</sign>");
        stringBuilder.append("</xml>");
        return stringBuilder.toString();
    }
}
