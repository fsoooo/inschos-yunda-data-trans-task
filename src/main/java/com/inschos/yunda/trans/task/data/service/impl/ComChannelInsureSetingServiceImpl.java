package com.inschos.yunda.trans.task.data.service.impl;

import com.inschos.yunda.trans.task.data.mapper.ComChannelInsureSetingMapper;
import com.inschos.yunda.trans.task.data.service.ComChannelInsureSetingService;
import com.inschos.yunda.trans.task.model.ComChannelInsureSeting;
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
public class ComChannelInsureSetingServiceImpl implements ComChannelInsureSetingService
{
    @Autowired
    private ComChannelInsureSetingMapper comChannelInsureSetingMapper;
    @Override
    public ComChannelInsureSeting selectOne(long id) {
        return comChannelInsureSetingMapper.selectOne(id);
    }

    @Override
    public List<ComChannelInsureSeting> selectPage(Page page) {
        return comChannelInsureSetingMapper.selectPage(page);
    }
}
