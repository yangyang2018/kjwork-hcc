package com.kj.front.controller;

import com.kj.comom.BaseResponse;
import com.kj.comom.CommonResultResponse;
import com.kj.constant.DictionaryEnum;
import com.kj.constant.HccConstant;
import com.kj.constant.ImageEnum;
import com.kj.model.SuppCompany;
import com.kj.model.SuppDictionary;
import com.kj.model.SuppImage;
import com.kj.model.SuppMessage;
import com.kj.service.SuppCompanyService;
import com.kj.service.SuppDictionaryService;
import com.kj.service.SuppImageService;
import com.kj.service.SuppMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/22 下午3:04
 * @description
 */
@RequestMapping("/front")
@Controller
public class ContactController {
    @Autowired
    SuppMessageService suppMessageService;


    @RequestMapping("/contact.action")
    public String services(ModelMap modelMap){
        return "front/contact";
    }

    @RequestMapping("/ajax/submit/message.action")
    @ResponseBody
    public BaseResponse submit(@RequestBody SuppMessage suppMessage){

        BaseResponse baseResponse = null;
        //1.参数效验
        if (org.apache.commons.lang3.StringUtils.isBlank(suppMessage.getFirstname())) {
            baseResponse =BaseResponse.buildFail();
            baseResponse.setResultInfo("姓不能为空");
            return baseResponse;
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(suppMessage.getLastname())) {
            baseResponse =CommonResultResponse.buildFail();
            baseResponse.setResultInfo("名不能为空");
            return baseResponse;
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(suppMessage.getPhone())) {
            baseResponse =CommonResultResponse.buildFail();
            baseResponse.setResultInfo("联系电话不能为空");
            return baseResponse;
        }
        //2.插入数据
        suppMessageService.insert(suppMessage);

        return CommonResultResponse.buildSuccess();
    }





}
