package com.inschos.yunda.trans.task.model;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public class CustWarranty {

    /** 主键*/
    public long id;

    /** 内部保单唯一标识*/
    public String warranty_uuid;

    /** 投保单号*/
    public String pre_policy_no;

    /** 保单号*/
    public String warranty_code;

    /** 组合产品  0 不是  1是*/
    public int comb_product;

    /** 组合保单号*/
    public String comb_warranty_code;

    /** 业务识别号*/
    public String business_no;

    /** 归属账号uuid*/
    public String manager_uuid;

    /** 买家uuid*/
    public String account_uuid;

    /** 代理人ID,为null则为用户自主购买*/
    public long agent_id;

    /** 渠道ID,为0则为用户自主购买*/
    public long channel_id;

    /** 计划书ID,为0则为用户自主购买*/
    public long plan_id;

    /** 产品ID*/
    public long product_id;

    /** 起保时间*/
    public long start_time;

    /** 结束时间*/
    public long end_time;

    /** 保险公司ID*/
    public long ins_company_id;

    /** 购买份数*/
    public int count;

    /** 缴别ID*/
    public long pay_category_id;

    /** 佣金 0表示未结算，1表示已结算*/
    public int is_settlement;

    /** 电子保单下载地址*/
    public String warranty_url;

    /** 保单来源 1 自购 2线上成交 3线下成交 4导入*/
    public int warranty_from;

    /** 保单类型,1表示个人保单，2表示团险保单，3表示车险保单*/
    public int type;

    /** 保单状态 1投保中, 2待生效,3保障中, 4可续保,5已过保，6已退保 7已失效*/
    public int warranty_status;

    /** 积分*/
    public String integral;

    /** 快递单号*/
    public String express_no;

    /** 快递公司名称*/
    public String express_company_name;

    /** 邮寄详细地址*/
    public String express_address;

    /** 邮寄省级代码*/
    public String express_province_code;

    /** 邮寄市级代码*/
    public String express_city_code;

    /** 邮寄地区代码*/
    public String express_county_code;

    /** 保单发送电子邮箱*/
    public String express_email;

    /** 快递方式，0-自取，1-快递*/
    public String delivery_type;

    /** 保单下单时间*/
    public long order_time;

    /** 投保回执CODE*/
    public String resp_code;

    /** 投保回执信息*/
    public String resp_msg;

    /** 创建时间*/
    public long created_at;

    /** 结束时间*/
    public long updated_at;

    /** 删除标识 0删除 1可用*/
    public int state;

}
