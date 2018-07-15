package com.inschos.yunda.trans.task.data.mapper;

import com.inschos.yunda.trans.task.data.database.DataSource;
import com.inschos.yunda.trans.task.model.BankAuthorize;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
@DataSource(value = DataSource.dataSource1)
public interface BankAuthorizeMapper {

    int insert(BankAuthorize record);

    int insertAll(List<BankAuthorize> list);

    int update(BankAuthorize update);

    BankAuthorize selectOne(long id);


}
