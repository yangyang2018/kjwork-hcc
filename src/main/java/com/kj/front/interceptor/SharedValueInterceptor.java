package com.kj.front.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/22 下午4:40
 * @description
 */
@Component
public class SharedValueInterceptor  implements HandlerInterceptor {


    @Value("${app.server.url}")
    public String appServerUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.getSession().setAttribute("appServerUrl",appServerUrl);
        return true;
    }
}
