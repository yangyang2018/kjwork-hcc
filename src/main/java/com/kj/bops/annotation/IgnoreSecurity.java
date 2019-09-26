package com.kj.bops.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/8/14 上午7:06
 * @description
 */
@Target( { ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreSecurity {

    String description() default "忽略权限";

}
