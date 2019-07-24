package com.kj.constant;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/23 下午7:04
 * @description
 */
public enum DictionaryEnum {

    COMPANY_SERVICEBASE(10002,"服务的原则"),
    COMPANY_QUALIFICATION(10000,"公司的荣誉"),
    COMPANY_COMMON_INFO(10003,"公司其他信息");

    DictionaryEnum(Integer code, String tag){
        this.code = code;
        this.tag = tag;
    }
    private Integer code;
    private String tag;

    public Integer getCode() {
        return code;
    }

    public String getTag() {
        return tag;
    }

}
