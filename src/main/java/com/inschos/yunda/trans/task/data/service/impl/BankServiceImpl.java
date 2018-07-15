package com.inschos.yunda.trans.task.data.service.impl;

import com.inschos.yunda.trans.task.data.mapper.BankMapper;
import com.inschos.yunda.trans.task.data.service.BankService;
import com.inschos.yunda.trans.task.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/15
 * version  v1.0.0
 */
@Repository
public class BankServiceImpl implements BankService {

    @Autowired
    private BankMapper bankMapper;

    @Override
    public int insert(Bank record) {
        return bankMapper.insert(record);
    }

    @Override
    public int insertAll(List<Bank> list) {
        if(list==null || list.isEmpty()){
            return 0;
        }
        int all = bankMapper.insertAll(list);
        if(all!=list.size()){
            return 0;
        }
        return all;
    }

    @Override
    public int update(Bank update) {
        return bankMapper.update(update);
    }

    @Override
    public Bank selectOne(long id) {
        return bankMapper.selectOne(id);
    }
}
