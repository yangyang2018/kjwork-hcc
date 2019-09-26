package com.kj.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kj.dao.SuppMessageDao;
import com.kj.model.SuppMessage;
import com.kj.service.SuppMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/23 上午11:21
 * @description
 */
@Service
public class SuppMessageServiceImpl extends ServiceImpl<SuppMessageDao,SuppMessage> implements SuppMessageService {

    @Autowired
    SuppMessageDao suppMessageDao;

    @Override
    public boolean updateStatus(Integer id) {
        return suppMessageDao.updateStatus(id);
    }
}
