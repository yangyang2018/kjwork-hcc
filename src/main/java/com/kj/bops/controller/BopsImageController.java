package com.kj.bops.controller;

import com.kj.constant.HccConstant;
import com.kj.constant.ImageEnum;
import com.kj.model.SuppCompany;
import com.kj.model.SuppImage;
import com.kj.model.SuppMember;
import com.kj.service.SuppCompanyService;
import com.kj.service.SuppImageService;
import com.kj.service.SuppMemberService;
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
public class BopsImageController {


    @Autowired
    SuppCompanyService suppCompanyService;
    @Autowired
    SuppImageService suppImageService;


    @RequestMapping("/company-image.action")
    public String index(ModelMap modelMap){
        SuppCompany suppCompany = suppCompanyService.selectCompany();
        modelMap.put("suppCompany",suppCompany);
        return "bops/company-image";

    }

    @RequestMapping("/circle-image.action")
    public String circle(ModelMap modelMap){
        //获取首页轮播图片路径
        List<SuppImage> suppImages = suppImageService.selectListByType(ImageEnum.HOMECIRCLE.getCode());
        modelMap.addAttribute("datas",suppImages);
        return "bops/circle-image";

    }





}
