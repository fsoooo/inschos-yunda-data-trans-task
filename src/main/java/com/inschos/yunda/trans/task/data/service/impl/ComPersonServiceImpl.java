package com.inschos.yunda.trans.task.data.service.impl;

import com.inschos.yunda.trans.task.data.mapper.ComPersonMapper;
import com.inschos.yunda.trans.task.data.service.ComPersonService;
import com.inschos.yunda.trans.task.model.ComPerson;
import com.inschos.yunda.trans.task.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
@Repository
public class ComPersonServiceImpl implements ComPersonService {

    @Autowired
    private ComPersonMapper comPersonMapper;

    @Override
    public ComPerson selectOne(long id) {
        return comPersonMapper.selectOne(id);
    }

    @Override
    public List<ComPerson> selectPage(Page page) {
        return comPersonMapper.selectPage(page);
    }
}
