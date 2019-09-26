package com.kj.bops.controller.ajax;

import com.kj.comom.BaseResponse;
import com.kj.comom.CommonResultResponse;
import com.kj.model.SuppServices;
import com.kj.service.SuppServicesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/9/1 下午2:54
 * @description
 */
@RestController
@RequestMapping("/bops/ajax/services/")
public class AJAXServicesController {


    @Autowired
    SuppServicesService suppServicesService;


    @RequestMapping("update.action")
    public BaseResponse publish(@RequestBody SuppServices suppServices){

        if(StringUtils.isBlank(suppServices.getTitle())){
            return BaseResponse.buildFail("关键字不能为空");
        }
        if(StringUtils.isBlank(suppServices.getContent())){
            return BaseResponse.buildFail("描述不能为空");
        }

        boolean  flag = suppServicesService.updateById(suppServices);
        //响应成功
        return flag ? CommonResultResponse.buildSuccess():CommonResultResponse.buildFail();
    }




}
