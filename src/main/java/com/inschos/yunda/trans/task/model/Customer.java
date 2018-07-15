package com.inschos.yunda.trans.task.model;

/**
 * author   meiming_mm@163.com
 * date     2018/7/15
 * version  v1.0.0
 */
public class Customer {
    /** */
    public long id;

    /** 所属账号id*/
    public String account_uuid;

    /** 所属业管账号id*/
    public String manager_uuid;

    /** 当前客户的类型1个人 2企业*/
    public int type;

    /** 代理人id*/
    public long agent_id;

    /** 分配时间*/
    public long allot_time;

    /** 对应类型的客户id*/
    public long customer_id;

    /** 客户标签 1,2,3形式存储*/
    public String user_tag_id;

    /** */
    public long created_at;

    /** */
    public long updated_at;

}
