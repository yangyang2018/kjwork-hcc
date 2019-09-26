package com.kj.bops.controller.ajax;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.kj.comom.BaseResponse;
import com.kj.constant.HccConstant;
import com.kj.model.SuppCompany;
import com.kj.model.SuppDictionary;
import com.kj.model.SuppMember;
import com.kj.service.SuppCompanyService;
import com.kj.service.SuppDictionaryService;
import com.kj.service.SuppMemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/9/1 下午2:54
 * @description
 */
@RestController
@RequestMapping("/bops/ajax/company/")
public class AJAXCompanyController {


    @Autowired
    SuppCompanyService suppCompanyService;

    @Autowired
    SuppDictionaryService suppDictionaryService;


    @RequestMapping("info/save.action")
    public BaseResponse info(HttpServletRequest request, HttpServletResponse response, @RequestBody SuppCompany suppCompany){

        if(StringUtils.isBlank(suppCompany.getName())){
            return BaseResponse.buildFail("公司名称不能为空");
        }
        if(StringUtils.isBlank(suppCompany.getProfile())){
            return BaseResponse.buildFail("公司简介不能为空");
        }
        //更新
        suppCompanyService.updateById(suppCompany);
        //响应成功
        return BaseResponse.buildSuccess();
    }

    @RequestMapping("basic/save.action")
    public BaseResponse basic(HttpServletRequest request, HttpServletResponse response, @RequestBody SuppCompany suppCompany){


        SuppDictionary simplesDic = suppCompany.getSimplesDic();
        if (simplesDic != null) {
            suppDictionaryService.update(simplesDic, new EntityWrapper<SuppDictionary>().eq("group_no", simplesDic.getGroupNo())
                    .eq("dic_no", simplesDic.getDicNo()));
        }


        SuppDictionary phoneDic = suppCompany.getPhoneDic();
        if (phoneDic != null) {
            suppDictionaryService.update(phoneDic, new EntityWrapper<SuppDictionary>().eq("group_no", phoneDic.getGroupNo())
                    .eq("dic_no", phoneDic.getDicNo()));
        }


        SuppDictionary emailDic = suppCompany.getEmailDic();
        if (emailDic != null) {
            suppDictionaryService.update(emailDic, new EntityWrapper<SuppDictionary>().eq("group_no", emailDic.getGroupNo())
                    .eq("dic_no", emailDic.getDicNo()));
        }

        SuppDictionary websiteDic = suppCompany.getWebsiteDic();
        if (websiteDic != null) {
            suppDictionaryService.update(websiteDic, new EntityWrapper<SuppDictionary>().eq("group_no", websiteDic.getGroupNo())
                    .eq("dic_no", websiteDic.getDicNo()));
        }


        SuppDictionary addressDic = suppCompany.getAddressDic();
        if (addressDic != null) {
            suppDictionaryService.update(addressDic, new EntityWrapper<SuppDictionary>().eq("group_no", addressDic.getGroupNo())
                    .eq("dic_no", addressDic.getDicNo()));
        }

        //响应成功
        return BaseResponse.buildSuccess();
    }





    @RequestMapping("dic/update.action")
    public BaseResponse saveHonor(HttpServletRequest request, HttpServletResponse response, @RequestBody SuppDictionary suppDictionary){

        if(StringUtils.isBlank(suppDictionary.getName())){
            return BaseResponse.buildFail("日期不能为空");
        }
        if(StringUtils.isBlank(suppDictionary.getRemark())){
            return BaseResponse.buildFail("事件不能为空");
        }
        //设置更新日期
        suppDictionary.setModifyTime(new Date());
        //更新
        boolean flag = suppDictionaryService.updateById(suppDictionary);
        //响应
        return flag?BaseResponse.buildSuccess():BaseResponse.buildFail();
    }








}
