package com.inschos.yunda.trans.task.data.service;

import com.inschos.yunda.trans.task.model.ComBank;
import com.inschos.yunda.trans.task.model.Page;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public interface ComBankService {

    ComBank selectOne(long id);

    List<ComBank> selectPage(Page page);
}
