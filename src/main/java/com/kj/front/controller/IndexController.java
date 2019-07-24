package com.kj.front.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.kj.constant.DictionaryEnum;
import com.kj.constant.HccConstant;
import com.kj.constant.ImageEnum;
import com.kj.model.*;
import com.kj.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/22 下午3:04
 * @description
 */
@RequestMapping("/front")
@Controller
public class IndexController {

    @Autowired
    SuppImageService suppImageService;

    @Autowired
    SuppServicesService suppServicesService;

    @Autowired
    SuppNewsService suppNewsService;

    @RequestMapping("/index.action")
    public String index(ModelMap modelMap){



        //获取首页轮播图片路径
        List<SuppImage> suppImages = suppImageService.selectListByType(ImageEnum.HOMECIRCLE.getCode());
        modelMap.addAttribute("circleImages",suppImages);

        //首页服务信息
        List<SuppServices> suppServices = suppServicesService.selectTopThree();
        modelMap.addAttribute("topThreeServices",suppServices);

        //首页新闻信息
        Page<SuppNews> suppNewsPage = suppNewsService.selectPage(new Page<>(1, 3),new EntityWrapper<SuppNews>().orderBy(HccConstant.ORDER,true));
        modelMap.addAttribute("news",suppNewsPage.getRecords());


        return "front/index";
    }
}
