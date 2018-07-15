package com.inschos.yunda.trans.task.data.service.impl;

import com.inschos.yunda.trans.task.data.mapper.ComBankMapper;
import com.inschos.yunda.trans.task.data.service.ComBankService;
import com.inschos.yunda.trans.task.model.ComBank;
import com.inschos.yunda.trans.task.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/15
 * version  v1.0.0
 */
@Repository
public class ComBankServiceImpl implements ComBankService {

    @Autowired
    private ComBankMapper comBankMapper;

    @Override
    public ComBank selectOne(long id) {
        return comBankMapper.selectOne(id);
    }

    @Override
    public List<ComBank> selectPage(Page page) {
        return comBankMapper.selectPage(page);
    }
}
