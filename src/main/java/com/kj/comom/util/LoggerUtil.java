package com.kj.comom.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/7/1 下午5:18
 * @description
 */
public class LoggerUtil {

    private static Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    public static void debug(Throwable throwable, Logger logger, String message, Object... params){
        if (logger.isDebugEnabled()) {
            logger.debug(message,params,throwable);
        }
    }

    public static void debug(Logger logger, String message, Object... params){
        if (logger.isDebugEnabled()) {
            logger.debug(message,params);
        }
    }


    public static void info(Throwable throwable, Logger logger, String message, Object... params){
        if (logger.isInfoEnabled()) {
            logger.info(message,params,throwable);
        }
    }

    public static void info(Logger logger, String message, Object... params){
        if (logger.isInfoEnabled()) {
            logger.info(message,params);
        }
    }

    public static void warn(Throwable throwable, Logger logger, String message, Object... params){
        if (logger.isWarnEnabled()) {
            logger.warn(message,params,throwable);
        }
    }

    public static void warn(Logger logger, String message, Object... params){
        if (logger.isWarnEnabled()) {
            logger.warn(message,params);
        }
    }


    public static void error(Throwable throwable, Logger logger, String message, Object... params){
        if (logger.isErrorEnabled()) {
            logger.error(message,params,throwable);
        }
    }

    public static void error(Logger logger, String message, Object... params){
        if (logger.isErrorEnabled()) {
            logger.error(message,params);
        }
    }



    public static void main(String[] args) {


        LoggerUtil.debug(logger,"你是[{}]","zhu",new NullPointerException());
        LoggerUtil.debug(logger,"你是[{}]","zhu");

    }


}
