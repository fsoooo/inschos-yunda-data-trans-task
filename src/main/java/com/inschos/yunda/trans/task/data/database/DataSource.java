package com.inschos.yunda.trans.task.data.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    public static String dataSource1 = "dataSource1"; // A数据源
    public static String dataSource2 = "dataSource2"; // B数据源
    String value();
}
