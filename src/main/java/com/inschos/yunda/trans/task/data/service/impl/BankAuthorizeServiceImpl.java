package com.inschos.yunda.trans.task.data.service.impl;

import com.inschos.yunda.trans.task.data.mapper.BankAuthorizeMapper;
import com.inschos.yunda.trans.task.data.service.BankAuthorizeService;
import com.inschos.yunda.trans.task.model.BankAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/15
 * version  v1.0.0
 */
@Repository
public class BankAuthorizeServiceImpl implements BankAuthorizeService {

    @Autowired
    private BankAuthorizeMapper bankAuthorizeMapper;

    @Override
    public int insert(BankAuthorize record) {
        return bankAuthorizeMapper.insert(record);
    }

    @Override
    public int insertAll(List<BankAuthorize> list) {
        return bankAuthorizeMapper.insertAll(list);
    }

    @Override
    public int update(BankAuthorize update) {
        return bankAuthorizeMapper.update(update);
    }

    @Override
    public BankAuthorize selectOne(long id) {
        return bankAuthorizeMapper.selectOne(id);
    }
}
