package com.inschos.yunda.trans.task.data.service;

import com.inschos.yunda.trans.task.model.ComCustWarranty;
import com.inschos.yunda.trans.task.model.Page;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public interface ComCustWarrantyService {

    ComCustWarranty selectOne(long id);

    List<ComCustWarranty> selectPage(Page page);
}
