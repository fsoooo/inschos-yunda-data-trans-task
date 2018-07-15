package com.inschos.yunda.trans.task.data.service;

import com.inschos.yunda.trans.task.model.ComChannelInsureSeting;
import com.inschos.yunda.trans.task.model.Page;

import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public interface ComChannelInsureSetingService {

    ComChannelInsureSeting selectOne(long id);

    List<ComChannelInsureSeting> selectPage(Page page);
}
