package com.kj.bops.controller;

import com.kj.constant.DictionaryEnum;
import com.kj.constant.HccConstant;
import com.kj.model.SuppCompany;
import com.kj.model.SuppDictionary;
import com.kj.model.SuppServices;
import com.kj.service.SuppCompanyService;
import com.kj.service.SuppDictionaryService;
import com.kj.service.SuppServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/8/13 下午9:51
 * @description
 */
@RequestMapping("/bops")
@Controller
public class BopsCompanyController {


    @Autowired
    SuppCompanyService suppCompanyService;

    @Autowired
    SuppDictionaryService suppDictionaryService;

    @Autowired
    SuppServicesService suppServicesService;


    @RequestMapping("/company-info.action")
    public String info(ModelMap modelMap){
        List<SuppCompany> suppMembers = suppCompanyService.selectList(null);
        SuppCompany suppCompany = suppMembers.size()>0?suppMembers.get(0):new SuppCompany();
        modelMap.put("suppCompany",suppCompany);
        return "bops/company-info";
    }


    @RequestMapping("/company-basic.action")
    public String basic(ModelMap modelMap){
        List<SuppDictionary> suppDictionaries = suppDictionaryService.selectList(DictionaryEnum.COMPANY_COMMON_INFO.stringCode());
        SuppCompany suppCompany = new SuppCompany();
        for (SuppDictionary suppDictionary : suppDictionaries) {
            final String dicNo = suppDictionary.getDicNo();
            switch (dicNo){
                case HccConstant.OTHER_PROFILE_INFO:
                    suppCompany.setSimplesDic(suppDictionary);
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
                case HccConstant.OTHER_ADDRESS_INFO:
                    suppCompany.setAddressDic(suppDictionary);
                    break;
                default:
                    continue;
            }
        }
        modelMap.put("suppCompany",suppCompany);
        return "bops/company-basic";
    }


    @RequestMapping("/company-target.action")
    public String target(ModelMap modelMap){
        List<SuppDictionary> targets = suppDictionaryService.selectList(DictionaryEnum.COMPANY_SERVICEBASE.stringCode());
        modelMap.put("targets",targets);
        return "bops/company-target";
    }


    @RequestMapping("/company-service.action")
    public String services(ModelMap modelMap){
        List<SuppServices> services = suppServicesService.selectList(null);
        modelMap.put("services",services);
        return "bops/company-service";
    }

    @RequestMapping("/company-honour.action")
    public String honour(ModelMap modelMap){
        List<SuppDictionary> honours = suppDictionaryService.selectList(DictionaryEnum.COMPANY_QUALIFICATION.stringCode());
        modelMap.put("honours",honours);
        return "bops/company-honour";
    }




}
