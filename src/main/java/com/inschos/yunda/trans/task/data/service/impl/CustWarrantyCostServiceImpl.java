package com.inschos.yunda.trans.task.data.service.impl;

import com.inschos.yunda.trans.task.data.mapper.CustWarrantyCostMapper;
import com.inschos.yunda.trans.task.data.service.CustWarrantyCostService;
import com.inschos.yunda.trans.task.model.CustWarrantyCost;
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
public class CustWarrantyCostServiceImpl implements CustWarrantyCostService {

    @Autowired
    private CustWarrantyCostMapper custWarrantyCostMapper;

    @Override
    public int insert(CustWarrantyCost record) {
        return custWarrantyCostMapper.insert(record);
    }

    @Override
    public int insertAll(List<CustWarrantyCost> list) {
        return custWarrantyCostMapper.insertAll(list);
    }

    @Override
    public int update(CustWarrantyCost update) {
        return custWarrantyCostMapper.update(update);
    }

    @Override
    public CustWarrantyCost selectOne(long id) {
        return custWarrantyCostMapper.selectOne(id);
    }

    @Override
    public List<CustWarrantyCost> selectPageValid(Page page) {
        return custWarrantyCostMapper.selectPageValid(page);
    }
}
