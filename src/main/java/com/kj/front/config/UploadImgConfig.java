package com.kj.front.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/23 上午8:15
 * @description
 */
@Component
@ConfigurationProperties(prefix = "upload")
public class UploadImgConfig {

    //上传路径
    private String uploadPath;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }




}
