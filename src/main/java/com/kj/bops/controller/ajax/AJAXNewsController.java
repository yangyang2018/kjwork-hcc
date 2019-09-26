package com.kj.bops.controller.ajax;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.kj.comom.BaseResponse;
import com.kj.comom.CommonResultResponse;
import com.kj.comom.page.NewsPageSearch;
import com.kj.model.SuppNews;
import com.kj.service.SuppNewsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/9/1 下午2:54
 * @description
 */
@RestController
@RequestMapping("/bops/ajax/news/")
public class AJAXNewsController {


    @Autowired
    SuppNewsService suppNewsService;



    @RequestMapping("page.action")
    public BaseResponse login(@RequestBody NewsPageSearch simplePage){

        EntityWrapper<SuppNews> suppNewsEntityWrapper = new EntityWrapper<>();
        if (StringUtils.isNotBlank(simplePage.getTitle())) {
            suppNewsEntityWrapper.like("title",simplePage.getTitle());
        }
        suppNewsEntityWrapper.orderBy("`order`",true);
        suppNewsEntityWrapper.orderBy("`create_time`",false);

        Page<SuppNews> page = new Page(simplePage.getPage(),simplePage.getPageSize());

        Page<SuppNews> suppNewsPage = suppNewsService.selectPage(page, suppNewsEntityWrapper);
        //设置数据
        simplePage.setData(suppNewsPage.getRecords());
        simplePage.setTotalCount(suppNewsPage.getTotal());
        //响应成功
        return CommonResultResponse.buildSuccess(simplePage);
    }


    @RequestMapping("{id}/delete.action")
    public BaseResponse login(@PathVariable("id") String id){

        Assert.hasText(id,"id不能为空");
        boolean b = suppNewsService.deleteById(Integer.valueOf(id));
        //响应成功
        return b ? CommonResultResponse.buildSuccess():CommonResultResponse.buildFail();
    }


    @RequestMapping("publish.action")
    public BaseResponse publish(@RequestBody SuppNews suppNews){

        boolean flag;
        if (suppNews.getId() == null) {
            //发布新闻
            flag = suppNewsService.insert(suppNews);
        }else {
            suppNews.setModifyTime(new Date());
            flag = suppNewsService.updateById(suppNews);
        }
        //响应成功
        return flag ? CommonResultResponse.buildSuccess():CommonResultResponse.buildFail();
    }


    @RequestMapping("{id}/query.action")
    public BaseResponse query(@PathVariable("id") String id){

        Assert.hasText(id,"id不能为空");
        SuppNews suppNews = suppNewsService.selectById(Integer.valueOf(id));
        //响应成功
        return suppNews !=null ? CommonResultResponse.buildSuccess(suppNews):CommonResultResponse.buildFail();
    }










}
