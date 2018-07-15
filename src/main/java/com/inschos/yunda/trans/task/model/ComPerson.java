package com.inschos.yunda.trans.task.model;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public class ComPerson {
    /** */
    public long id;

    /** 姓名*/
    public String name;

    /** 证件类型，1：身份证，2：护照，3：军官证，4：其他*/
    public int papers_type;

    /** 证件号*/
    public String papers_code;

    /** 身份证开始时间*/
    public String papers_start;

    /** 身份证结束时间*/
    public String papers_end;

    /** 1、男 2、女*/
    public int sex;

    /** 生日*/
    public long birthday;

    /** 家庭住址*/
    public String address;

    /** */
    public String address_detail;

    /** 联系方式*/
    public String phone;

    /** 邮件*/
    public String email;

    /** 邮编*/
    public String postcode;

    /** 客户类型，1：普通用户，2：代理人*/
    public int cust_type;

    /** 认证状态，1：未认证，2：已认证*/
    public int authentication;

    /** 身份证上面*/
    public String up_url;

    /** 身份证背面*/
    public String down_url;

    /** 身份证手持*/
    public String person_url;

    /** 头像*/
    public String head;

    /** 绑定当前公司id*/
    public long company_id;

    /** 删除标识 1为已经删除*/
    public int del;

    /** 当前用户状态，1：正常，2：异常*/
    public int status;

    /** */
    public long created_at;

    /** */
    public long updated_at;

}
