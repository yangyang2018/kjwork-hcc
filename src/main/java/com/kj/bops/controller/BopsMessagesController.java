package com.kj.bops.controller;

import com.kj.service.SuppMessageService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BopsMessagesController {


    @Autowired
    SuppMessageService suppMessageService;

    @RequestMapping("/messages.action")
    public String index(ModelMap modelMap){
        return "bops/messages-list";

    }






}
