package com.kj.filter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.kj.constant.HccConstant.BOPS;
import static com.kj.constant.HccConstant.LOGIN_ACTION;
import static com.kj.constant.HccConstant.TOKEN;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/9/1 下午2:59
 * @description
 */
@WebFilter
public class BopsLoginFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(BopsLoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        logger.info("BopsLoginFilter init ... ");
    }

    @Override
    public void destroy() {

        logger.info("BopsLoginFilter destroy ... ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        String requestURI = req.getRequestURI();
        logger.debug("requestURI:"+requestURI);
        if(StringUtils.indexOf(requestURI,BOPS)<=0){
            //非bops请求 --- 请求继续
            chain.doFilter(request,response);
            return;
        }
        if(StringUtils.endsWith(requestURI,"/bops/login.action")
                ||StringUtils.endsWith(requestURI,"/bops/ajax/login.action")){
            //bops 登录请求以及AJAX发送登录请求
            chain.doFilter(request,response);
            return;
        }
        if(!requestURI.endsWith(".action")){
            //非页面请求和后台请求
            chain.doFilter(request,response);
            return;
        }

        HttpSession session = req.getSession();
        String token = (String) session.getAttribute(TOKEN);
        if(StringUtils.isBlank(token)){
            //没有登录过--前往登录页面
            ((HttpServletResponse) response).sendRedirect("/bops/login.action");
            return;
        }
        //请求继续
        chain.doFilter(request,response);
    }
}
