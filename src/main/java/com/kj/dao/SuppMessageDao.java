package com.kj.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kj.model.SuppMessage;
import org.apache.ibatis.annotations.Param;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/27 下午5:49
 * @description
 */
public interface SuppMessageDao extends BaseMapper<SuppMessage> {
    /**
     * 更新状态为已处理
     * @param id
     * @return
     */
    boolean updateStatus(@Param("id") Integer id);
}
