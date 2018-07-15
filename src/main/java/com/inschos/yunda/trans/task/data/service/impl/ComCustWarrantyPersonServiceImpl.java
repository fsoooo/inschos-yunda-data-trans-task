package com.inschos.yunda.trans.task.data.service.impl;

import com.inschos.yunda.trans.task.data.mapper.ComCustWarrantyPersonMapper;
import com.inschos.yunda.trans.task.data.service.ComCustWarrantyPersonService;
import com.inschos.yunda.trans.task.model.ComCustWarrantyPerson;
import com.inschos.yunda.trans.task.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/15
 * version  v1.0.0
 */
@Repository
public class ComCustWarrantyPersonServiceImpl implements ComCustWarrantyPersonService {

    @Autowired
    private ComCustWarrantyPersonMapper comCustWarrantyPersonMapper;

    @Override
    public ComCustWarrantyPerson selectOne(long id) {
        return comCustWarrantyPersonMapper.selectOne(id);
    }

    @Override
    public List<ComCustWarrantyPerson> selectPage(Page page) {
        return comCustWarrantyPersonMapper.selectPage(page);
    }
}
