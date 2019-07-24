package com.kj.constant;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/23 下午7:04
 * @description
 */
public enum ResultCodeEnum {

    SUCCESS("000000","操作成功"),
    FAILURE("000001","操作失败");

    ResultCodeEnum(String code, String tag){
        this.code = code;
        this.tag = tag;
    }
    private String code;
    private String tag;

    public String getCode() {
        return code;
    }

    public String getTag() {
        return tag;
    }

}
