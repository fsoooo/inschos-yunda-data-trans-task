package com.inschos.yunda.trans.task.data.service;

import com.inschos.yunda.trans.task.model.Person;
import com.inschos.yunda.trans.task.model.PersonRefer;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public interface PersonService {

    int insert(Person record);

    List<PersonRefer> addAll(List<Person> list);

    int update(Person update);

    Person findOne(long id);
}
