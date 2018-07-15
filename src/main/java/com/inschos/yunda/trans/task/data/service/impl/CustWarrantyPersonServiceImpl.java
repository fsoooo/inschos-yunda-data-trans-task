package com.inschos.yunda.trans.task.data.service.impl;

import com.inschos.yunda.trans.task.data.mapper.CustWarrantyPersonMapper;
import com.inschos.yunda.trans.task.data.service.CustWarrantyPersonService;
import com.inschos.yunda.trans.task.model.CustWarrantyPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/15
 * version  v1.0.0
 */
@Repository
public class CustWarrantyPersonServiceImpl implements CustWarrantyPersonService {

    @Autowired
    private CustWarrantyPersonMapper custWarrantyPersonMapper;

    @Override
    public int insert(CustWarrantyPerson record) {
        return custWarrantyPersonMapper.insert(record);
    }

    @Override
    public int insertAll(List<CustWarrantyPerson> list) {
        if(list==null || list.isEmpty()){
            return 0;
        }
        int row = custWarrantyPersonMapper.insertAll(list);
        if(row!=list.size()){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
        return row;
    }

    @Override
    public int update(CustWarrantyPerson update) {
        return custWarrantyPersonMapper.update(update);
    }

    @Override
    public CustWarrantyPerson selectOne(long id) {
        return custWarrantyPersonMapper.selectOne(id);
    }
}
