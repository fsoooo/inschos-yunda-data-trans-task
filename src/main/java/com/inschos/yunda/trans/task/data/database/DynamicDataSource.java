package com.inschos.yunda.trans.task.data.database;

import com.inschos.common.assist.kit.L;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {

        L.log.debug("getDataSource :{}",DataSourceHolder.getDataSource());
        return DataSourceHolder.getDataSource();
    }
}
