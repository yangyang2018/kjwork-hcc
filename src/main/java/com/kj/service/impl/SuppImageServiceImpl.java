package com.kj.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kj.constant.ImageEnum;
import com.kj.dao.SuppImageDao;
import com.kj.model.SuppImage;
import com.kj.service.SuppImageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/23 上午11:21
 * @description
 */
@Service
public class SuppImageServiceImpl extends ServiceImpl<SuppImageDao,SuppImage> implements SuppImageService {

    @Override
    public List<SuppImage> selectListByType(Integer type) {
        return super.selectList(new EntityWrapper<SuppImage>().eq("type", type).orderBy("`order`", true));
    }
}
