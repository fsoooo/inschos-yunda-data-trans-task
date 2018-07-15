package com.inschos.yunda.trans.task.model;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public class Bank {

    /** 主键id*/
    public long id;

    /** 账号唯一标识*/
    public String account_uuid;

    /** 银行名称：工商银行,建设银行等*/
    public String bank_name;

    /** 开户行城市(地址)*/
    public String bank_city;

    /** 银行卡号*/
    public String bank_code;

    /** 银行卡类型：储蓄卡，借记卡等*/
    public String bank_type;

    /** 银行卡绑定手机*/
    public String phone;

    /** 审核状态(授权状态):是否通过审核检验，默认1未审核,2已审核,3审核失败*/
    public int status;

    /** 删除标识;默认1未删除,2已删除*/
    public int state;

    /** */
    public long created_at;

    /** */
    public long updated_at;


}
