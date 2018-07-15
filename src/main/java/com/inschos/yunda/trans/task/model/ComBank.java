package com.inschos.yunda.trans.task.model;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public class ComBank {
    /** */
    public long id;

    /** 客户类型 1、个人 2、企业*/
    public int cust_type;

    /** */
    public long cust_id;

    /** 开户银行*/
    public String bank;

    /** */
    public String bank_code;

    /** 开户地址*/
    public String bank_city;

    /** */
    public int bank_deal_type;

    /** 预留手机*/
    public String phone;

    /** */
    public long created_at;

    /** */
    public long updated_at;

    /** */
    public int state;

}
