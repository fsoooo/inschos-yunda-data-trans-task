package com.inschos.yunda.trans.task.model;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public class Account {

    /** */
    public long id;

    /** account_uuid*/
    public String account_uuid;

    /** 用户名*/
    public String username;

    /** 密码*/
    public String password;

    /** 个人账号手机号*/
    public String phone;

    /** 邮箱*/
    public String email;

    /** token*/
    public String token;

    /** 1：正常，2，异常*/
    public int status;

    /** 渠道系统ID*/
    public long sys_id;

    /** 用户类型：1：个人账号，2：企业账号，3：业管账号，4：代理人*/
    public int user_type;

    /** 用户ID*/
    public String user_id;

    /** */
    public String salt;

    /** 账户来源*/
    public String origin;

    /** 创建时间*/
    public long created_at;

    /** 结束时间*/
    public long updated_at;

    /** 删除标识 0删除 1可用*/
    public int state;

}
