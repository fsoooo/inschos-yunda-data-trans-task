package com.inschos.yunda.trans.task.data.service;

import com.inschos.yunda.trans.task.model.CustWarrantyPerson;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public interface CustWarrantyPersonService {

    int insert(CustWarrantyPerson record);

    int insertAll(List<CustWarrantyPerson> list);

    int update(CustWarrantyPerson update);

    CustWarrantyPerson selectOne(long id);


}
