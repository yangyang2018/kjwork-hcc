package com.kj.model;

import java.io.Serializable;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/8/14 上午7:12
 * @description
 */
public class SuppToken extends BaseSuppDO implements Serializable {
    private static final long serialVersionUID = -7553794283473906854L;

    private String userId;//用户ID
    private String appName;//app名称
    private String accessToken;//token


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
