package com.inschos.yunda.trans.task.data.service;

import com.inschos.yunda.trans.task.data.database.DataSource;
import com.inschos.yunda.trans.task.model.Account;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public interface AccountService {

    int insert(Account account);

    int insertAll(List<Account> accounts);

    int update(Account account);

    Account selectOne(long id);


}
