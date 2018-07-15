package com.inschos.yunda.trans.task.model;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public class ComChannelInsureSeting {

    /** 主键id,自增*/
    public int id;

    /** */
    public String cust_cod;

    /** user_id,与用户表关联*/
    public int cust_id;

    /** 用户类型*/
    public String cust_type;

    /** */
    public String authorize_start;

    /** */
    public String authorize_bank;

    /** 授权状态*/
    public int authorize_status;

    /** 保单id*/
    public String warranty_id;

    /** 保障天数*/
    public String insure_days;

    /** 起保时间*/
    public String insure_start;

    /** */
    public int auto_insure_status;

    /** */
    public String auto_insure_price;

    /** */
    public String auto_insure_type;

    /** */
    public String auto_insure_time;

    /** */
    public String updated_at;

}
