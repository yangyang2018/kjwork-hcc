package com.kj.service;

import com.baomidou.mybatisplus.service.IService;
import com.kj.model.SuppServices;

import java.util.List;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/23 上午11:22
 * @description
 */
public interface SuppServicesService   extends IService<SuppServices> {

    List<SuppServices> selectList();
    List<SuppServices> selectTopThree();
}
