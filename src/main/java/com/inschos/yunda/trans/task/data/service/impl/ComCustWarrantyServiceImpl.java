package com.inschos.yunda.trans.task.data.service.impl;

import com.inschos.yunda.trans.task.data.mapper.ComCustWarrantyMapper;
import com.inschos.yunda.trans.task.data.service.ComCustWarrantyService;
import com.inschos.yunda.trans.task.model.ComCustWarranty;
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
public class ComCustWarrantyServiceImpl implements ComCustWarrantyService {

    @Autowired
    private ComCustWarrantyMapper comCustWarrantyMapper;

    @Override
    public ComCustWarranty selectOne(long id) {
        return comCustWarrantyMapper.selectOne(id);
    }

    @Override
    public List<ComCustWarranty> selectPage(Page page) {
        return comCustWarrantyMapper.selectPage(page);
    }

    @Override
    public List<ComCustWarranty> selectPageValid(Page page) {
        return comCustWarrantyMapper.selectPageValid(page);
    }
}
