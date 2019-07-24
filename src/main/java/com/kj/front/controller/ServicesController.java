package com.kj.front.controller;

import com.kj.model.SuppServices;
import com.kj.service.SuppServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
public class ServicesController {



    @Autowired
    SuppServicesService suppServicesService;

    @RequestMapping("/services.action")
    public String services(ModelMap modelMap){

        //服务信息
        List<SuppServices> suppServices = suppServicesService.selectList();
        modelMap.addAttribute("services",suppServices);

        return "front/services";
    }
}
