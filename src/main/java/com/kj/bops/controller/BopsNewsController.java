package com.kj.bops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/8/13 下午9:51
 * @description
 */
@RequestMapping("/bops")
@Controller
public class BopsNewsController {


    /**
     * 列表页面
     * @param modelMap
     * @return
     */
    @RequestMapping("/news.action")
    public String index(ModelMap modelMap){
        return "bops/news-list";
    }

    /**
     * 发布页面-编辑页面
     * @param modelMap
     * @return
     */
    @RequestMapping("/news-publish.action")
    public String publish(ModelMap modelMap, @RequestParam(name = "newsId",required = false)String newsId){
        modelMap.put("newsId",newsId);
        return "bops/news-publish";
    }


}
