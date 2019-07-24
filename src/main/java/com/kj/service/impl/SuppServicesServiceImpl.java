package com.kj.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kj.dao.SuppImageDao;
import com.kj.dao.SuppServicesDao;
import com.kj.model.SuppImage;
import com.kj.model.SuppServices;
import com.kj.service.SuppImageService;
import com.kj.service.SuppServicesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/23 上午11:21
 * @description
 */
@Service
public class SuppServicesServiceImpl extends ServiceImpl<SuppServicesDao,SuppServices> implements SuppServicesService {

    @Override
    public List<SuppServices> selectList() {
        return super.selectList(new EntityWrapper<SuppServices>().orderBy("`order`", true));
    }

    @Override
    public List<SuppServices> selectTopThree() {
        Page<SuppServices> page = new Page<>(1,3);
        return super.selectPage(page).getRecords();
    }
}
