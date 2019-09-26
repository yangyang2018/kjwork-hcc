package com.kj.bops.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.kj.model.SuppMember;
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
public class BopsMemberController {


    @Autowired
    SuppMemberService suppMemberService;


    @RequestMapping("/member-list.action")
    public String index(ModelMap modelMap){
        List<SuppMember> suppMembers = suppMemberService.selectList(null);
        modelMap.put("members",suppMembers);
        return "bops/member-list";

    }





}
