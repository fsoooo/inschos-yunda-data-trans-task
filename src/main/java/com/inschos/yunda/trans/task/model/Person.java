package com.inschos.yunda.trans.task.model;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public class Person {

    /** */
    public long id;

    /** 姓名*/
    public String name;

    /** 头像key*/
    public String head;

    /** 昵称*/
    public String nickname;

    /** 证件类型，1：身份证，2：护照，3：军官证，4：其他*/
    public int cert_type;

    /** 证件号*/
    public String cert_code;

    /** 证件开始时间*/
    public long cert_start;

    /** 证件结束时间*/
    public long cert_end;

    /** 认证状态 1未认证 2认证通过 3认证失败*/
    public int authentication;

    /** 1、男 2、女*/
    public int sex;

    /** 生日*/
    public long birthday;

    /** 家庭住址*/
    public String address;

    /** 详细地址*/
    public String address_detail;

    /** 联系方式*/
    public String phone;

    /** 邮件*/
    public String email;

    /** 身份证上面*/
    public String front_key;

    /** 身份证背面*/
    public String back_key;

    /** 身份证手持*/
    public String handheld_key;

    /** 删除标识 0为已经删除 1未删除*/
    public int state;

    /** */
    public long created_at;

    /** */
    public long updated_at;


    public long oldId;



}
