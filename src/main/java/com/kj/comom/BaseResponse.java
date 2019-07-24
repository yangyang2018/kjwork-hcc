package com.kj.comom;

import java.io.Serializable;

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
}
