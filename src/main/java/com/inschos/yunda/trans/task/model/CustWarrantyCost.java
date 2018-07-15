package com.inschos.yunda.trans.task.model;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public class CustWarrantyCost {
    /** 主键*/
    public long id;

    /** 内部保单唯一标识*/
    public String warranty_uuid;

    /** 应支付时间*/
    public long pay_time;

    /** 分期：第几期*/
    public int phase;

    /** 保单价格*/
    public String premium;

    /** 税费*/
    public String tax_money;

    /** 实际支付时间*/
    public long actual_pay_time;

    /** 支付方式 1 银联 2 支付宝 3 微信 4现金*/
    public long pay_way;

    /** 付款金额*/
    public String pay_money;

    /** 支付状态 200-待核保 201-核保中 202-核保失败 203-待支付 204-支付中 205-支付取消 206-支付成功 207支付失败 210预投保*/
    public int pay_status;

    /** 结算状态 0-未结算，1-已结算*/
    public int is_settlement;

    /** 结算单uuid*/
    public String bill_uuid;

    /** 创建时间*/
    public long created_at;

    /** 结束时间*/
    public long updated_at;

}
