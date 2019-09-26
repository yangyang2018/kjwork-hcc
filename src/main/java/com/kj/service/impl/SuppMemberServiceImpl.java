package com.kj.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kj.dao.SuppMemberDao;
import com.kj.dao.SuppMessageDao;
import com.kj.model.SuppMember;
import com.kj.model.SuppMessage;
import com.kj.service.SuppMemberService;
import com.kj.service.SuppMessageService;
import net.sf.ehcache.search.query.QueryManager;
import org.springframework.stereotype.Service;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/23 上午11:21
 * @description
 */
@Service
public class SuppMemberServiceImpl extends ServiceImpl<SuppMemberDao,SuppMember> implements SuppMemberService {

    @Override
    public SuppMember selectMemberByUsername(String name) {
        return super.selectOne(new EntityWrapper().eq("username",name));
    }
}
