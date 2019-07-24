package com.kj.comom;

import com.kj.constant.ResultCodeEnum;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/27 下午5:27
 * @description
 */
public class CommonResultResponse extends BaseResponse{

    public static CommonResultResponse buildSuccess(){
        CommonResultResponse commonResultResponse = new CommonResultResponse();
        commonResultResponse.setSuccess(true);
        commonResultResponse.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        commonResultResponse.setResultInfo(ResultCodeEnum.SUCCESS.getTag());
        return commonResultResponse;
    }

    public static CommonResultResponse buildFailure(){
        CommonResultResponse commonResultResponse = new CommonResultResponse();
        commonResultResponse.setSuccess(false);
        commonResultResponse.setResultCode(ResultCodeEnum.FAILURE.getCode());
        commonResultResponse.setResultInfo(ResultCodeEnum.FAILURE.getTag());
        return commonResultResponse;
    }
}
