package com.kj.front.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.kj.constant.DictionaryEnum;
import com.kj.constant.HccConstant;
import com.kj.constant.ImageEnum;
import com.kj.model.SuppCompany;
import com.kj.model.SuppDictionary;
import com.kj.model.SuppImage;
import com.kj.model.SuppNews;
import com.kj.service.SuppCompanyService;
import com.kj.service.SuppDictionaryService;
import com.kj.service.SuppImageService;
import com.kj.service.SuppNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/22 下午3:04
 * @description
 */
@RequestMapping("/front")
@Controller
public class NewsController {

    @Autowired
    SuppNewsService suppNewsService;

    @RequestMapping("/news.action")
    public String services(ModelMap modelMap,@RequestParam(value = "pageIndex",required = false) Integer pageIndex,@RequestParam(value = "pageSize",required = false) Integer pageSize){
        if(pageIndex == null){
            pageIndex =1;
        }
        if(pageSize == null){
            pageSize =HccConstant.DEFAULT_PAGESIZE;
        }
        //新闻的分页信息
        Page<SuppNews> page = new Page<>(pageIndex,pageSize);
        List<SuppNews> records = suppNewsService.selectPage(page,new EntityWrapper<SuppNews>().orderBy(HccConstant.ORDER,true)).getRecords();
        modelMap.addAttribute("news",records);
        modelMap.addAttribute("pageIndex",page.getCurrent());
        modelMap.addAttribute("totalPage",page.getPages());
        return "front/news";
    }

    @RequestMapping("/news_detail.action")
    public String servicesDetail(ModelMap modelMap,@RequestParam("id") String id){
        Assert.hasText(id,"参数不准确");
        //新闻的详细页信息
        SuppNews suppNews = suppNewsService.selectById(Integer.valueOf(id));
        modelMap.put("news",suppNews);
        return "front/news_detail";
    }
}
