package com.inschos.yunda.trans.task.data.service.impl;

import com.inschos.yunda.trans.task.data.mapper.CustWarrantyBrokerageMapper;
import com.inschos.yunda.trans.task.data.service.CustWarrantyBrokerageService;
import com.inschos.yunda.trans.task.model.CustWarrantyBrokerage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/19
 * version  v1.0.0
 */
@Repository
public class CustWarrantyBrokerageServiceImpl implements CustWarrantyBrokerageService {

    @Autowired
    private CustWarrantyBrokerageMapper custWarrantyBrokerageMapper;

    @Override
    public int insert(CustWarrantyBrokerage record) {
        return custWarrantyBrokerageMapper.insert(record);
    }

    @Override
    public int insertAll(List<CustWarrantyBrokerage> list) {
        return list!=null&&!list.isEmpty()?custWarrantyBrokerageMapper.insertAll(list):0;
    }

    @Override
    public int update(CustWarrantyBrokerage update) {
        return custWarrantyBrokerageMapper.update(update);
    }

    @Override
    public CustWarrantyBrokerage selectOne(long id) {
        return custWarrantyBrokerageMapper.selectOne(id);
    }
}
