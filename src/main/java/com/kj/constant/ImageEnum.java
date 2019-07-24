package com.kj.constant;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/23 下午7:04
 * @description
 */
public enum  ImageEnum {

    HOMECIRCLE(10010001,"首页轮播图片类型"),
    COMPANYHOME(10000000,"公司展示图片类型"),

    NEWSHOME(11000000,"新闻展示图片类型");

    ImageEnum(Integer code,String tag){
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
