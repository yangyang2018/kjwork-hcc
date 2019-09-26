package com.kj.comom.aop;

import com.kj.comom.util.LoggerUtil;
import com.kj.constant.DictionaryEnum;
import com.kj.constant.HccConstant;
import com.kj.constant.ImageEnum;
import com.kj.front.util.CacheUtil;
import com.kj.model.SuppCompany;
import com.kj.model.SuppDictionary;
import com.kj.model.SuppImage;
import com.kj.service.SuppCompanyService;
import com.kj.service.SuppDictionaryService;
import com.kj.service.SuppImageService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/7/1 下午4:35
 * @description
 */
@Component
@Aspect
public class FrontControllerAspect {

    private Logger logger = LoggerFactory.getLogger(FrontControllerAspect.class);

    @Autowired
    private SuppCompanyService suppCompanyService;

    @Autowired
    private SuppDictionaryService suppDictionaryService;


    @Autowired
    private CacheUtil cacheUtil;



    @Pointcut(value = "execution(* com.kj.*.controller..*.*(..))")
    public void frontDiv(){

    }


    @Around("frontDiv()")
    public Object doBefore(ProceedingJoinPoint proceedingJoinPointt) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String requestUrl = request.getRequestURL().toString();
        // 记录下请求内容
        LoggerUtil.info(logger,"URL : " + requestUrl);
        LoggerUtil.info(logger,"HTTP_METHOD : " + request.getMethod());
        LoggerUtil.info(logger,"IP : " + request.getRemoteAddr());
        LoggerUtil.info(logger,"CLASS_METHOD : " + proceedingJoinPointt.getSignature().getDeclaringTypeName() + "." + proceedingJoinPointt.getSignature().getName());
        LoggerUtil.info(logger,"ARGS : " + Arrays.toString(proceedingJoinPointt.getArgs()));

        /**
         * ajax请求不拦截
         */
        if(requestUrl.indexOf("ajax")>0){
            return  proceedingJoinPointt.proceed();
        }

        Object[] args = proceedingJoinPointt.getArgs();


        ModelMap modelMap;
        if(args.length > 0){
            if(args[0] instanceof ModelMap){
                SuppCompany companyInfo;
                modelMap = (ModelMap)args[0];
                //公司相关信息先从缓存中取，如果缓存中没有再从数据库里查询
                Object suppCompany = cacheUtil.getCacheByKey(HccConstant.COMMONCACHE, HccConstant.CACHE_KEY_COMPANY);
                if(suppCompany != null){
                    LoggerUtil.info(logger,"从缓存中取...");
                    companyInfo = (SuppCompany) suppCompany;
                    modelMap.addAttribute("company",companyInfo);
                }else{
                    //
                    LoggerUtil.info(logger,"从数据库中取...");
                    companyInfo = getCompanyInfo();
                    //存入缓存
                    cacheUtil.putCache(HccConstant.COMMONCACHE,HccConstant.CACHE_KEY_COMPANY,companyInfo);
                    modelMap.addAttribute("company", companyInfo);
                }
            }
        }
        return  proceedingJoinPointt.proceed();
    }
    /**
     * 页面上公共数据/获取公司信息
     * @return
     */
    public SuppCompany getCompanyInfo(){

        //首页公司信息
        SuppCompany suppCompany = suppCompanyService.selectCompany();
        if (suppCompany == null) {
            SuppImage suppImage =new SuppImage();
            suppImage.setPath(HccConstant.DEFAULT_COMPANY_IMAGE);
        }
        //其他信息
        List<SuppDictionary> supps = suppDictionaryService.selectList(DictionaryEnum.COMPANY_COMMON_INFO.getCode().toString());
        String dicNo = null;
        for (SuppDictionary suppDictionary : supps) {
            dicNo = suppDictionary.getDicNo();
            switch (dicNo){
                case HccConstant.OTHER_PROFILE_INFO:
                    suppCompany.setSimplesDic(suppDictionary);
                    break;
                case HccConstant.OTHER_ADDRESS_INFO:
                    suppCompany.setAddressDic(suppDictionary);
                    break;
                case HccConstant.OTHER_PHONE_INFO:
                    suppCompany.setPhoneDic(suppDictionary);
                    break;
                case HccConstant.OTHER_EMAIL_INFO:
                    suppCompany.setEmailDic(suppDictionary);
                    break;
                case HccConstant.OTHER_WEBSIT_INFO:
                    suppCompany.setWebsiteDic(suppDictionary);
                    break;
                default:
                    break;
            }
        }
        return suppCompany;
    }









}
