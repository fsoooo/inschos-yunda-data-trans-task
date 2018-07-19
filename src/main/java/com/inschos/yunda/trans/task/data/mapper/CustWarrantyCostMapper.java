package com.inschos.yunda.trans.task.data.mapper;

import com.inschos.yunda.trans.task.data.database.DataSource;
import com.inschos.yunda.trans.task.model.CustWarrantyCost;
import com.inschos.yunda.trans.task.model.Page;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
@DataSource(value = DataSource.dataSource1)
public interface CustWarrantyCostMapper {

    int insert(CustWarrantyCost record);

    int insertAll(List<CustWarrantyCost> list);

    int update(CustWarrantyCost update);

    CustWarrantyCost selectOne(long id);

    List<CustWarrantyCost> selectPageValid(Page page);


}
