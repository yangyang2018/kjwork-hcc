package com.kj.bops.controller.ajax;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.kj.comom.BaseResponse;
import com.kj.comom.CommonResultResponse;
import com.kj.comom.page.NewsMessageSearch;
import com.kj.comom.page.NewsPageSearch;
import com.kj.model.SuppMessage;
import com.kj.model.SuppNews;
import com.kj.service.SuppMessageService;
import com.kj.service.SuppNewsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/bops/ajax/messages/")
public class AJAXMessagesController {

    @Autowired
    SuppMessageService suppMessageService;

    @RequestMapping("page.action")
    public BaseResponse login(@RequestBody NewsMessageSearch simplePage){

        EntityWrapper<SuppMessage> suppMessageEntityWrapper = new EntityWrapper<>();
        if (StringUtils.isNotBlank(simplePage.getSubject())) {
            suppMessageEntityWrapper.like("subject",simplePage.getSubject());
        }
        suppMessageEntityWrapper.orderBy("`create_time`",false);

        Page<SuppMessage> page = new Page(simplePage.getPage(),simplePage.getPageSize());

        Page<SuppMessage> suppNewsPage = suppMessageService.selectPage(page, suppMessageEntityWrapper);
        //设置数据
        simplePage.setData(suppNewsPage.getRecords());
        simplePage.setTotalCount(suppNewsPage.getTotal());
        //响应成功
        return CommonResultResponse.buildSuccess(simplePage);
    }


    @RequestMapping("{id}/delete.action")
    public BaseResponse login(@PathVariable("id") String id){

        Assert.hasText(id,"id不能为空");
        boolean b = suppMessageService.deleteById(Integer.valueOf(id));
        //响应成功
        return b ? CommonResultResponse.buildSuccess():CommonResultResponse.buildFail();
    }

    @RequestMapping("{id}/handle.action")
    public BaseResponse handle(@PathVariable("id") String id){

        Assert.hasText(id,"id不能为空");
        boolean b = suppMessageService.updateStatus(Integer.valueOf(id));
        //响应成功
        return b ? CommonResultResponse.buildSuccess():CommonResultResponse.buildFail();
    }

    @RequestMapping("{id}/query.action")
    public BaseResponse query(@PathVariable("id") String id){

        Assert.hasText(id,"id不能为空");
        SuppMessage suppMessage = suppMessageService.selectById(Integer.valueOf(id));
        //响应成功
        return suppMessage !=null ? CommonResultResponse.buildSuccess(suppMessage):CommonResultResponse.buildFail();
    }










}
