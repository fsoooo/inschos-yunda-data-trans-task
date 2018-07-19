package com.inschos.yunda.trans.task.data.service;

import com.inschos.yunda.trans.task.model.CustWarrantyBrokerage;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public interface CustWarrantyBrokerageService {

    int insert(CustWarrantyBrokerage record);

    int insertAll(List<CustWarrantyBrokerage> list);

    int update(CustWarrantyBrokerage update);

    CustWarrantyBrokerage selectOne(long id);


}
