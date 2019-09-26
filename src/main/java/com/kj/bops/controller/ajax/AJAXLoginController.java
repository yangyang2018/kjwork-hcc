package com.kj.bops.controller.ajax;

import com.kj.comom.BaseResponse;
import com.kj.constant.HccConstant;
import com.kj.front.util.CacheUtil;
import com.kj.model.SuppMember;
import com.kj.service.SuppMemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/9/1 下午2:54
 * @description
 */
@RestController
@RequestMapping("/bops/ajax/")
public class AJAXLoginController {


    @Autowired
    SuppMemberService suppMemberService;



    @RequestMapping("login.action")
    public BaseResponse login(HttpServletRequest request, HttpServletResponse response, @RequestBody SuppMember suppMember){

        if(StringUtils.isBlank(suppMember.getUsername())){
            return BaseResponse.buildFail("用户名不能为空");
        }
        if(StringUtils.isBlank(suppMember.getPassword())){
            return BaseResponse.buildFail("密码不能为空");
        }

        SuppMember suppMemberDB = suppMemberService.selectMemberByUsername(suppMember.getUsername());

        if (suppMemberDB == null) {
            return BaseResponse.buildFail("用户不存在");
        }

        if (!StringUtils.equals(suppMemberDB.getPassword(),suppMember.getPassword())) {
            return BaseResponse.buildFail("密码不正确");
        }
        //设置token
        HttpSession session = request.getSession();
        StringBuilder sign = new StringBuilder(suppMember.getUsername());
        session.setAttribute(HccConstant.TOKEN,sign.toString());
        //响应成功
        return BaseResponse.buildSuccess();
    }


    @RequestMapping("login-out.action")
    public BaseResponse loginOut(HttpServletRequest request, HttpServletResponse response){

        //设置session失效
        HttpSession session = request.getSession();
        session.invalidate();
        //响应成功
        return BaseResponse.buildSuccess();
    }










}
