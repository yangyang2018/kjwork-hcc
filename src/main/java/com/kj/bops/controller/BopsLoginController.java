package com.kj.bops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/8/13 下午9:51
 * @description
 */
@RequestMapping("/bops")
@Controller
public class BopsLoginController {


    @RequestMapping("/login.action")
    public String index(ModelMap modelMap){
        return "bops/login";

    }






}
