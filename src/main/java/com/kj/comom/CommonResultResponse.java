package com.kj.comom;

import com.kj.constant.ResultCodeEnum;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/27 下午5:27
 * @description
 */
public class CommonResultResponse<T> extends BaseResponse{

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static CommonResultResponse buildSuccess(Object data){
        CommonResultResponse commonResultResponse = new CommonResultResponse();
        commonResultResponse.setSuccess(true);
        commonResultResponse.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        commonResultResponse.setResultInfo(ResultCodeEnum.SUCCESS.getTag());
        commonResultResponse.setData(data);
        return commonResultResponse;
    }


    public static CommonResultResponse buildFailure(Object data){
        CommonResultResponse commonResultResponse = new CommonResultResponse();
        commonResultResponse.setSuccess(false);
        commonResultResponse.setResultCode(ResultCodeEnum.FAILURE.getCode());
        commonResultResponse.setResultInfo(ResultCodeEnum.FAILURE.getTag());
        commonResultResponse.setData(data);
        return commonResultResponse;
    }
}
