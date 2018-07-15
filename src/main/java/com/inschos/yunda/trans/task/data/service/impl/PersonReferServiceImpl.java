package com.inschos.yunda.trans.task.data.service.impl;

import com.inschos.yunda.trans.task.data.mapper.PersonReferMapper;
import com.inschos.yunda.trans.task.data.service.PersonReferService;
import com.inschos.yunda.trans.task.model.PersonRefer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
@Component
public class PersonReferServiceImpl implements PersonReferService {

    @Autowired
    private PersonReferMapper personReferMapper;

    @Override
    public int insert(PersonRefer record) {
        return personReferMapper.insert(record);
    }

    @Override
    public int insertAll(List<PersonRefer> list) {
        return personReferMapper.insertAll(list);
    }

    @Override
    public int update(PersonRefer update) {
        return personReferMapper.update(update);
    }

    @Override
    public PersonRefer selectOne(long id) {
        return personReferMapper.selectOne(id);
    }

    @Override
    public PersonRefer selectByOutPerson(long id) {
        return personReferMapper.selectByOutPerson(id);
    }

    @Override
    public PersonRefer selectLastOne() {
        return personReferMapper.selectLastOne();
    }
}
