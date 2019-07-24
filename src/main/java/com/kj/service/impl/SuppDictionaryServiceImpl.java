package com.kj.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kj.dao.SuppDictionaryDao;
import com.kj.model.SuppDictionary;
import com.kj.service.SuppDictionaryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/6/23 上午11:21
 * @description
 */
@Service
public class SuppDictionaryServiceImpl extends ServiceImpl<SuppDictionaryDao,SuppDictionary> implements SuppDictionaryService {

    @Override
    public List<SuppDictionary> selectList(String groupNo) {
        return super.selectList(new EntityWrapper<SuppDictionary>().eq("group_no",groupNo).orderBy("dic_no", true));

    }
}
