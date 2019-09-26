package com.kj.comom;

import org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/27 下午5:27
 * @description
 */
public class BaseResponse implements Serializable{


    private static final long serialVersionUID = -1266460054997243674L;

    private boolean success;

    private String  resultCode;

    private String  resultInfo;

    public BaseResponse() {

    }

    public BaseResponse(String resultCode) {
        this.resultCode = resultCode;
    }

    public BaseResponse(boolean success, String resultCode) {
        this.success = success;
        this.resultCode = resultCode;
    }


    public BaseResponse(String resultCode, String resultInfo) {
        this.resultCode = resultCode;
        this.resultInfo = resultInfo;
    }

    public BaseResponse(boolean success, String resultCode, String resultInfo) {
        this.success = success;
        this.resultCode = resultCode;
        this.resultInfo = resultInfo;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public static BaseResponse buildSuccess() {
        BaseResponse response = new BaseResponse();
        response.setSuccess(true);
        response.setResultCode("0");
        response.setResultInfo("操作成功");
        return response;
    }


    public static BaseResponse buildFail(String resultInfo) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(false);
        response.setResultInfo(resultInfo);
        return response;
    }

    public static BaseResponse buildFail() {
        BaseResponse response = new BaseResponse();
        response.setSuccess(false);
        response.setResultInfo("操作失败");
        return response;
    }

    public static void main(String[] args) {

        try {
            Constructor<?> constructor = ConfigurationWarningsApplicationContextInitializer.class.getDeclaredConstructor(new Class[]{});


            System.out.println(constructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
