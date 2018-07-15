package com.inschos.yunda.trans.task.data.service;

import com.inschos.yunda.trans.task.data.database.DataSource;
import com.inschos.yunda.trans.task.model.PersonRefer;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
@DataSource(value = DataSource.dataSource1)
public interface PersonReferService {

    int insert(PersonRefer record);

    int insertAll(List<PersonRefer> list);

    int update(PersonRefer update);

    PersonRefer selectOne(long id);

    PersonRefer selectByOutPerson(long id);

    PersonRefer selectLastOne();



}
