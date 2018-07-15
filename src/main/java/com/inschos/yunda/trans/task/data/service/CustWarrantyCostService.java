package com.inschos.yunda.trans.task.data.service;

import com.inschos.yunda.trans.task.model.CustWarrantyCost;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public interface CustWarrantyCostService {

    int insert(CustWarrantyCost record);

    int insertAll(List<CustWarrantyCost> list);

    int update(CustWarrantyCost update);

    CustWarrantyCost selectOne(long id);


}
