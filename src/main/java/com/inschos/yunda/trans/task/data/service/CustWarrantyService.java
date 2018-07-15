package com.inschos.yunda.trans.task.data.service;

import com.inschos.yunda.trans.task.model.CustWarranty;
import com.inschos.yunda.trans.task.model.CustWarrantyCost;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public interface CustWarrantyService {

    int insert(CustWarranty record);

    int addAll(List<CustWarranty> list, List<CustWarrantyCost> costList);

    int update(CustWarranty update);

    CustWarranty selectOne(long id);


}
