package com.inschos.yunda.trans.task.data.service;

import com.inschos.yunda.trans.task.model.Bank;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public interface BankService {


    int insert(Bank record);

    int insertAll(List<Bank> list);

    int update(Bank update);

    Bank selectOne(long id);


}
