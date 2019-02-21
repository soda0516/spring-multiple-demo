package com.example.springmultipledemo.common;

/**
 * @Describe
 * @Author orang
 * @Create 2019/2/13 15:40
 **/
public class ResponseBuilder {
    //禁止通过new来构造函数
    private ResponseBuilder(){

    }

    /**
     * 执行成功，但是没有返回结果
     * @return
     */
    public static ResponseModel<String> successExcludeBody(){
        ResponseModel<String> responseModel = new ResponseModel<>();
        responseModel.setCode(1);
        responseModel.setBody("成功的返回结果");
        return responseModel;
    }

    /**
     * 返回一个具有泛型的返回结果
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResponseModel<T> successContainBody(T t){
        ResponseModel<T> responseModel = new ResponseModel<>();
        responseModel.setCode(2);
        responseModel.setBody(t);
        return responseModel;
    }

    /**
     * 返回一个未知的错误
     * @return
     */
    public static ResponseModel<String> errorUnknown(){
        ResponseModel<String> responseModel = new ResponseModel<>();
        responseModel.setCode(3);
        responseModel.setBody("未知的错误，请联系管理员！");
        return responseModel;
    }

    /**
     * 返回一个具有错误信息的结果，通常用在统一异常管理里面
     * @param body
     * @return
     */
    public static ResponseModel<String> errorContainBody(String body){
        ResponseModel<String> responseModel = new ResponseModel<>();
        responseModel.setCode(4);
        responseModel.setBody(body);
        return responseModel;
    }
}
