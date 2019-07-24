package com.kj.front.controller;

import com.kj.constant.DictionaryEnum;
import com.kj.constant.HccConstant;
import com.kj.constant.ImageEnum;
import com.kj.model.SuppCompany;
import com.kj.model.SuppDictionary;
import com.kj.model.SuppImage;
import com.kj.service.SuppCompanyService;
import com.kj.service.SuppDictionaryService;
import com.kj.service.SuppImageService;
import com.kj.service.SuppServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/22 下午3:04
 * @description
 */
@RequestMapping("/front")
@Controller
public class AboutController{

    @Autowired
    private SuppDictionaryService suppDictionaryService;

    @RequestMapping("/about.action")
    public String services(ModelMap modelMap){

        //荣誉
        List<SuppDictionary> qualifications = suppDictionaryService.selectList(DictionaryEnum.COMPANY_QUALIFICATION.getCode().toString());
        modelMap.addAttribute("qualifications",qualifications);

        //准则
        List<SuppDictionary> suppDictionaries = suppDictionaryService.selectList(DictionaryEnum.COMPANY_SERVICEBASE.getCode().toString());
        modelMap.addAttribute("bases",suppDictionaries);

        return "front/about";
    }
}
