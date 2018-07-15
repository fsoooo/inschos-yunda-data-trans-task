package com.inschos.yunda.trans.task.data.service;

import com.inschos.yunda.trans.task.model.BankAuthorize;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public interface BankAuthorizeService {

    int insert(BankAuthorize record);

    int insertAll(List<BankAuthorize> list);

    int update(BankAuthorize update);

    BankAuthorize selectOne(long id);


}
