package com.kj;

import com.kj.front.config.UploadImgConfig;
import com.kj.front.interceptor.SharedValueInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/22 下午4:08
 * @description
 */
@Configuration
public class WebConfiger implements WebMvcConfigurer {

    @Autowired
    private SharedValueInterceptor sharedValueInterceptor;

    @Autowired
    private UploadImgConfig uploadImgConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/images/**").addResourceLocations("file:///"+uploadImgConfig.getUploadPath());

    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean<DispatcherServlet> servletServletRegistrationBean = new ServletRegistrationBean<>(dispatcherServlet);
        servletServletRegistrationBean.addUrlMappings("/");
        servletServletRegistrationBean.addUrlMappings("*.action");
        servletServletRegistrationBean.addUrlMappings("*.html");
        servletServletRegistrationBean.addUrlMappings("*.css");
        servletServletRegistrationBean.addUrlMappings("*.js");
        servletServletRegistrationBean.addUrlMappings("*.png");
        servletServletRegistrationBean.addUrlMappings("*.gif");
        servletServletRegistrationBean.addUrlMappings("*.ico");
        servletServletRegistrationBean.addUrlMappings("*.jpeg");
        servletServletRegistrationBean.addUrlMappings("*.jpg");
        servletServletRegistrationBean.addUrlMappings("*.ttf");
        servletServletRegistrationBean.addUrlMappings("*.woff");
        return servletServletRegistrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(sharedValueInterceptor).addPathPatterns("/**");
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/front/index.action");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }


    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        // resolver.setDefaultEncoding("UTF-8");  
        // resolver.setResolveLazily(true);// resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常  
        // resolver.setMaxInMemorySize(40960);  
        resolver.setMaxUploadSize(5*1024*1024);// 上传文件大小 5M 5*1024*1024 
        return resolver;
    }
}
