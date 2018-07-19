package com.inschos.yunda.trans.task.model;

/**
 * author   meiming_mm@163.com
 * date     2018/7/19
 * version  v1.0.0
 */
public class CustWarrantyBrokerage {

    /** 主键*/
    public long id;

    /** 内部保单唯一标识*/
    public String warranty_uuid;

    /** 归属账号uuid*/
    public String manager_uuid;

    /** 缴费ID*/
    public long cost_id;

    /** 渠道ID*/
    public long channel_id;

    /** 代理人ID*/
    public long agent_id;

    /** 保单佣金*/
    public String warranty_money="0";

    /** */
    public String ins_money="0";

    /** 业管佣金*/
    public String manager_money="0";

    /** 渠道佣金*/
    public String channel_money="0";

    /** 代理人佣金*/
    public String agent_money="0";

    /** 保单佣金比例*/
    public String warranty_rate="";

    /** */
    public String ins_rate="";

    /** 业管佣金比例*/
    public String manager_rate="";

    /** 渠道佣金比例*/
    public String channel_rate="";

    /** 代理人佣金比例*/
    public String agent_rate="";

    /** 车险核算佣金*/
    public String car_integral="0";

    /** 创建时间*/
    public long created_at;

    /** 结束时间*/
    public long updated_at;



}
