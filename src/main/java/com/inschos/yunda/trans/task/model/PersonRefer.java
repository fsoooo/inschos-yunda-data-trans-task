package com.inschos.yunda.trans.task.model;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public class PersonRefer {
    /** 主键id*/
    public long id;

    /** 其他表person_id*/
    public long out_person_id;

    /** person表唯一标识*/
    public long person_id;

    /** */
    public String manager_uuid;

    /** 账号唯一标识*/
    public String account_uuid;

    /** */
    public long created_at;

    /** */
    public long updated_at;

}
