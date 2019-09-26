package com.kj.bops.controller.ajax;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.kj.comom.BaseResponse;
import com.kj.constant.HccConstant;
import com.kj.front.util.CacheUtil;
import com.kj.model.SuppCompany;
import com.kj.model.SuppImage;
import com.kj.service.SuppCompanyService;
import com.kj.service.SuppImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/9/1 下午2:54
 * @description
 */
@RestController
@RequestMapping("/bops/ajax/image/")
public class AJAXImageController {


    @Autowired
    SuppCompanyService suppCompanyService;

    @Autowired
    SuppImageService suppImageService;


    @Autowired
    CacheUtil cacheUtil;



    @RequestMapping("company/update.action")
    public BaseResponse companyImage(HttpServletRequest request, HttpServletResponse response
            , @RequestParam("newPath") String newPath
            , @RequestParam("id") String id) {
        Assert.hasText(newPath, "文件路径为空");
        Assert.hasText(id, "主键不能为空");

        SuppCompany suppCompany = new SuppCompany();
        suppCompany.setImagePath(newPath);
        boolean flag = suppCompanyService.update(suppCompany, new EntityWrapper<SuppCompany>().eq("id", id));

        //清除缓存
        cacheUtil.removeCache(HccConstant.COMMONCACHE, HccConstant.CACHE_KEY_COMPANY);

        return flag ? BaseResponse.buildSuccess() : BaseResponse.buildFail();


    }

    @RequestMapping("circle/update.action")
    public BaseResponse circleImageUpdate(HttpServletRequest request, HttpServletResponse response
            , @RequestParam("newPath") String newPath
            , @RequestParam("id") String id) {
        Assert.hasText(newPath, "文件路径为空");
        Assert.hasText(id, "主键不能为空");

        SuppImage suppImage = new SuppImage();
        suppImage.setPath(newPath);
        boolean flag = suppImageService.update(suppImage, new EntityWrapper<SuppImage>().eq("id", id));

        return flag ? BaseResponse.buildSuccess() : BaseResponse.buildFail();


    }


}
