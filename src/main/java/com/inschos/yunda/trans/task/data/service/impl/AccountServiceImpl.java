package com.inschos.yunda.trans.task.data.service.impl;

import com.inschos.yunda.trans.task.data.mapper.AccountMapper;
import com.inschos.yunda.trans.task.data.service.AccountService;
import com.inschos.yunda.trans.task.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
@Repository
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int insert(Account account) {
        return accountMapper.insert(account);
    }

    @Override
    public int insertAll(List<Account> accounts) {
        return accountMapper.insertAll(accounts);
    }

    @Override
    public int update(Account account) {
        return accountMapper.update(account);
    }

    @Override
    public Account selectOne(long id) {
        return accountMapper.selectOne(id);
    }
}
