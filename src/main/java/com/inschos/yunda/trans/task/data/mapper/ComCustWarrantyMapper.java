package com.inschos.yunda.trans.task.data.mapper;

import com.inschos.yunda.trans.task.data.database.DataSource;
import com.inschos.yunda.trans.task.model.ComCustWarranty;
import com.inschos.yunda.trans.task.model.Page;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
@DataSource(value = DataSource.dataSource2)
public interface ComCustWarrantyMapper {

    ComCustWarranty selectOne(long id);

    List<ComCustWarranty> selectPage(Page page);
}
