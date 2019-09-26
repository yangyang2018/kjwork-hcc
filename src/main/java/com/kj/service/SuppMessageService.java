package com.kj.service;

import com.baomidou.mybatisplus.service.IService;
import com.kj.model.SuppMessage;
import com.kj.model.SuppServices;

import java.util.List;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/23 上午11:22
 * @description
 */
public interface SuppMessageService extends IService<SuppMessage> {

    /**
     * 更新消息的状态为已处理
     * @param id
     * @return
     */
    boolean updateStatus(Integer id);
}
