package com.inschos.yunda.trans.task.data.service.impl;

import com.inschos.yunda.trans.task.data.mapper.CustWarrantyCostMapper;
import com.inschos.yunda.trans.task.data.mapper.CustWarrantyMapper;
import com.inschos.yunda.trans.task.data.service.CustWarrantyService;
import com.inschos.yunda.trans.task.model.CustWarranty;
import com.inschos.yunda.trans.task.model.CustWarrantyCost;
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
public class CustWarrantyServiceImpl implements CustWarrantyService {

    @Autowired
    private CustWarrantyMapper custWarrantyMapper;
    @Autowired
    private CustWarrantyCostMapper custWarrantyCostMapper;

    @Override
    public int insert(CustWarranty record) {
        return custWarrantyMapper.insert(record);
    }

    @Override
    public int addAll(List<CustWarranty> list, List<CustWarrantyCost> costList) {
        if(list==null || list.isEmpty()){
            return 0;
        }
        int row = custWarrantyMapper.insertAll(list);
        if(row==list.size()){
            int rowCost = custWarrantyCostMapper.insertAll(costList);
            if(rowCost!=costList.size()){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return 0;
            }
        }else{
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
        return row;
    }

    @Override
    public int update(CustWarranty update) {
        return custWarrantyMapper.update(update);
    }

    @Override
    public CustWarranty selectOne(long id) {
        return custWarrantyMapper.selectOne(id);
    }
}
