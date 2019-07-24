package com.kj.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kj.dao.SuppCompanyDao;
import com.kj.dao.SuppDictionaryDao;
import com.kj.model.SuppCompany;
import com.kj.model.SuppDictionary;
import com.kj.service.SuppCompanyService;
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
public class SuppCompanyServiceImpl extends ServiceImpl<SuppCompanyDao,SuppCompany> implements SuppCompanyService {


    @Override
    public SuppCompany selectCompany() {
        return super.selectOne(null);
    }
}
