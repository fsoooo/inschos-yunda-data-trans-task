package com.inschos.yunda.trans.task.task;

import com.inschos.common.assist.kit.L;
import com.inschos.common.assist.kit.StringKit;
import com.inschos.common.assist.kit.TimeKit;
import com.inschos.yunda.trans.task.data.service.*;
import com.inschos.yunda.trans.task.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
@Component
public class TaskDo {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonReferService personReferService;
    @Autowired
    private ComPersonService comPersonService;
    @Autowired
    private ComBankService comBankService;
    @Autowired
    private BankService bankService;
    @Autowired
    private ComCustWarrantyService comCustWarrantyService;
    @Autowired
    private CustWarrantyService custWarrantyService;
    @Autowired
    private ComCustWarrantyPersonService comCustWarrantyPersonService;
    @Autowired
    private CustWarrantyPersonService custWarrantyPersonService;

    @Autowired
    private ComChannelInsureSetingService comChannelInsureSetingService;
    @Autowired
    private BankAuthorizeService bankAuthorizeService;
    @Autowired
    private CustWarrantyCostService custWarrantyCostService;
    @Autowired
    private CustWarrantyBrokerageService custWarrantyBrokerageService;


    private final int limit = 1000;

    private final String filePath = "/data/a.properties";

    @Scheduled(cron = "1 53 11 19 7 *")
    public void cronOnce(){
        run();
    }
    @Scheduled(cron = "0 25 11 * * *")
    public void cronEvDay(){
        run();
    }


    public void run() {

        L.log.info("run");

        PersonRefer personRefer = personReferService.selectLastOne();
        long lastId = 0;

        Map<Long, String> cacheAccountUuid = new HashMap<>();

        if (personRefer != null) {
            lastId = personRefer.person_id;
        }
        L.log.info("lastId : {}",lastId);

        Properties prop = getProperties();

        if(prop.getProperty("personLastId", "0").equals("0")){

            L.log.error("personLastId  is  not ");

            return;
        }

        L.log.info("personLastId : {}",prop.getProperty("personLastId", "0"));

        L.log.info("bankLastId : {}",prop.getProperty("bankLastId", "0"));

        L.log.info("warrantyLastId : {}",prop.getProperty("warrantyLastId", "0"));


        L.log.info("warrantyLastPersonId : {}",prop.getProperty("warrantyLastPersonId", "0"));


        long s = System.currentTimeMillis();
        long flag = doPerson(cacheAccountUuid, lastId);
        prop.setProperty("personLastId",flag+"");


        long e = System.currentTimeMillis();
        L.log.info("do Perosn time :{} ; flag :{}",e-s,flag);
        s=System.currentTimeMillis();


        String bankLastId = prop.getProperty("bankLastId", "0");

        lastId = Long.valueOf(bankLastId);
        flag = doBank(cacheAccountUuid, lastId);
        prop.setProperty("bankLastId",flag+"");


        e = System.currentTimeMillis();
        L.log.info("do bank time :{} ; flag :{}",e-s,flag);
        s=System.currentTimeMillis();

        String warrantyLastId = prop.getProperty("warrantyLastId", "0");
        lastId = Long.valueOf(warrantyLastId);
        flag = doWarraty(cacheAccountUuid, lastId);
        prop.setProperty("warrantyLastId",flag+"");



        e = System.currentTimeMillis();
        L.log.info("do warranty time :{} ; flag :{}",e-s,flag);
        s=System.currentTimeMillis();

        String warrantyLastPersonId = prop.getProperty("warrantyLastPersonId", "0");
        lastId = Long.valueOf(warrantyLastPersonId);
        flag = doWarratyPerson(cacheAccountUuid, lastId);
        prop.setProperty("warrantyLastPersonId",flag+"");


        e = System.currentTimeMillis();
        L.log.info("do warranty person time :{} ; flag :{}",e-s,flag);



        String brokerageLastPersonId = prop.getProperty("brokerageLastPersonId", "0");
        lastId = Long.valueOf(brokerageLastPersonId);
        flag = doBrokerage( lastId);
        prop.setProperty("brokerageLastPersonId",flag+"");

        e = System.currentTimeMillis();
        L.log.info("do warranty person time :{} ; flag :{}",e-s,flag);




        savePeroperties(prop);

    }

    public void testDo(){
        Properties prop = getProperties();
        long s = System.currentTimeMillis();
        String brokerageLastPersonId = prop.getProperty("brokerageLastPersonId", "0");
        long lastId = Long.valueOf(brokerageLastPersonId);
        long flag = doBrokerage( lastId);
        prop.setProperty("brokerageLastPersonId",flag+"");

        long e = System.currentTimeMillis();
        L.log.info("do warranty person time :{} ; flag :{}",e-s,flag);

        savePeroperties(prop);

    }

    private long doPerson(Map<Long, String> cacheAccountUuid, long lastId) {
        Page personPage = new Page();
        personPage.offset = limit;


        //account  person
        List<ComPerson> personList = null;

        do {
            personPage.lastId = lastId;
            personList = comPersonService.selectPage(personPage);

            if (personList != null && !personList.isEmpty()) {
                List<Person> dataList = new ArrayList<>();
                long preLastId = lastId;
                for (ComPerson comPerson : personList) {
                    Person person = new Person();
                    person.name = comPerson.name;
                    person.head = comPerson.head;
                    person.cert_type = comPerson.papers_type;
                    person.cert_code = comPerson.papers_code;
                    person.cert_start = StringKit.isEmpty(comPerson.papers_start) ? 0 : Long.valueOf(comPerson.papers_start);
                    person.cert_end = StringKit.isEmpty(comPerson.papers_end) ? 0 : Long.valueOf(comPerson.papers_end);
                    person.authentication = comPerson.authentication;
                    person.sex = comPerson.sex;
                    person.birthday = comPerson.birthday;
                    person.address = comPerson.address;
                    person.address_detail = comPerson.address_detail;
                    person.phone = comPerson.phone;
                    person.email = comPerson.email;
                    person.front_key = comPerson.up_url;
                    person.back_key = comPerson.down_url;
                    person.handheld_key = comPerson.person_url;
                    person.state = 1;//0删除
                    person.created_at = comPerson.created_at;
                    person.updated_at = comPerson.updated_at;

                    person.oldId = comPerson.id;
                    lastId = comPerson.id;
                    dataList.add(person);
                }
                List<PersonRefer> personRefers = personService.addAll(dataList);

                if (personRefers == null) {
                    L.log.error("insert all  person  failed ");
                    return preLastId;
                } else {
                    for (PersonRefer refer : personRefers) {
                        cacheAccountUuid.put(refer.out_person_id, refer.account_uuid);
                    }
                }
            }

        } while (personList != null && personList.size() == limit);
        return lastId;
    }

    private long doBank(Map<Long, String> cacheAccountUuid, long lastId) {



        Page bankPage = new Page();
        bankPage.offset = limit;
        List<ComBank> bankList = null;
        do {
            bankPage.lastId = lastId;
            bankList = comBankService.selectPage(bankPage);
            if (bankList != null && !bankList.isEmpty()) {
                List<Bank> banks = new ArrayList<>();
                long preLastId = lastId;
                for (ComBank comBank : bankList) {
                    String aUuid = getUuid(cacheAccountUuid,comBank.cust_id);
                    if (!StringKit.isEmpty(aUuid)) {
                        Bank bank = new Bank();
                        bank.account_uuid = aUuid;
                        bank.bank_name = comBank.bank;
                        bank.bank_city = comBank.bank_city;
                        bank.bank_code = comBank.bank_code;
                        bank.phone = comBank.phone;
                        bank.status = 1;
                        bank.state = 1;
                        bank.created_at = comBank.created_at;
                        bank.updated_at = comBank.updated_at;
                        banks.add(bank);

                    }
                    lastId = comBank.id;
                }

                int allRow = bankService.insertAll(banks);
                if (allRow == 0) {
                    return preLastId;
                }

            }
        } while (bankList != null && bankList.size() == limit);
        return lastId;
    }

    private long doWarraty(Map<Long, String> cacheAccountUuid, long lastId) {
        Page wPage = new Page();
        wPage.offset = limit;
        List<ComCustWarranty> comCustWarranties = null;
        wPage.curTime = TimeKit.getDayStartTime();
        do {
            wPage.lastId = lastId;
            comCustWarranties = comCustWarrantyService.selectPage(wPage);
            if (comCustWarranties != null && !comCustWarranties.isEmpty()) {

                List<CustWarranty> warranties = new ArrayList<>();
                List<CustWarrantyCost> costList = new ArrayList<>();

                long preLastId = lastId;
                for (ComCustWarranty old : comCustWarranties) {


                    CustWarranty warranty = new CustWarranty();
                    warranty.warranty_uuid = old.warranty_uuid;//不为空
                    warranty.pre_policy_no = old.pro_policy_no;
                    warranty.warranty_code = old.warranty_code;
                    warranty.comb_product = old.comb_product;//'组合产品  0 不是  1是',
                    warranty.comb_warranty_code = old.comb_warranty_code;//组合保单号
                    warranty.business_no = old.business_no;//业务识别号

                    warranty.manager_uuid = "14463303497682968";
                    String uuid = getUuid(cacheAccountUuid, old.user_id);
                    warranty.account_uuid = StringKit.isEmpty(uuid)?String.valueOf(old.user_id):uuid;

                    warranty.agent_id = old.agent_id;
                    warranty.channel_id = old.ditch_id;
                    warranty.plan_id = old.plan_id;
                    warranty.product_id = 90;
                    warranty.start_time = old.start_time;
                    warranty.end_time = old.end_time;
                    warranty.ins_company_id = 55;
                    warranty.count = 1;//购买份数
                    warranty.pay_category_id = 38;//缴别ID
                    warranty.order_time = old.created_at;//保单下单时间
                    warranty.is_settlement = old.is_settlement;
                    warranty.warranty_url = old.warranty_url;
                    warranty.warranty_from = old.warranty_from;//不为空,保单来源 1 自购 2线上成交 3线下成交 4导入
                    warranty.type = old.type;


                    switch (old.warranty_status) {
                        case 2:
                            warranty.warranty_status = 1;
                            break;
                        case 4:
                            warranty.warranty_status = 4;
                            break;
                        case 6:
                            warranty.warranty_status = 6;
                            break;
                        case 8:
                            warranty.warranty_status = 5;
                            break;
                    }
                    warranty.resp_msg = !StringKit.isEmpty(old.resp_insure_msg) ? old.resp_insure_msg : old.resp_pay_msg;//投保回执信息
                    warranty.state = old.state;//删除标识 0删除 1可用
                    warranty.created_at = old.created_at;
                    warranty.updated_at = old.updated_at;
                    warranties.add(warranty);

                    CustWarrantyCost cost = new CustWarrantyCost();
                    cost.warranty_uuid = old.warranty_uuid;//不为空
                    cost.pay_time = old.created_at;//应支付时间
                    cost.phase = 1;//分期：第几期
                    cost.premium = old.premium;//保单价格
                    cost.actual_pay_time = old.created_at;//实际支付时间
                    cost.pay_way = old.pay_way;//支付方式 1 银联 2 支付宝 3 微信 4现金
                    cost.pay_money = old.premium;

                    switch (old.pay_status) {
                        case 0:
                            cost.pay_status = 202;
                            break;
                        case 1:
                            cost.pay_status = 204;
                            break;
                        case 2:
                            cost.pay_status = 202;
                            break;
                        case 3:
                            cost.pay_status = 206;
                            break;
                    }
                    cost.is_settlement = old.is_settlement;
                    cost.created_at = old.created_at;
                    cost.updated_at = old.updated_at;

                    costList.add(cost);
                    lastId = old.id;
                }
                if (custWarrantyService.addAll(warranties, costList) != warranties.size()) {
                    return preLastId;
                }

            }
        } while (comCustWarranties != null && comCustWarranties.size() == limit);

        return lastId;
    }

    private long doWarratyPerson(Map<Long, String> cache, long lastId) {
        Page pWPage = new Page();
        List<ComCustWarrantyPerson> comPersonList = null;
        pWPage.offset = limit;
        do {
            pWPage.lastId = lastId;
            comPersonList = comCustWarrantyPersonService.selectPage(pWPage);

            if (comPersonList != null && !comPersonList.isEmpty()) {
                List<CustWarrantyPerson> warrantyPersonList = new ArrayList<>();
                long preLastId = lastId;
                for (ComCustWarrantyPerson warrantyPerson : comPersonList) {
                    CustWarrantyPerson wPerson = new CustWarrantyPerson();
                    wPerson.warranty_uuid = warrantyPerson.warranty_uuid;//不为空
                    wPerson.type = warrantyPerson.type;
                    wPerson.relation_name = "1";
                    wPerson.out_order_no = warrantyPerson.out_order_no;
                    wPerson.name = warrantyPerson.name;
                    wPerson.card_type = warrantyPerson.card_type;
                    wPerson.card_code = warrantyPerson.card_code;
                    wPerson.phone = warrantyPerson.phone;
                    wPerson.occupation = warrantyPerson.occupation;
                    wPerson.birthday = warrantyPerson.birthday;
                    wPerson.sex = warrantyPerson.sex;
                    wPerson.age = warrantyPerson.age;
                    wPerson.email = warrantyPerson.email;
                    wPerson.nationality = warrantyPerson.nationality;
                    wPerson.annual_income = warrantyPerson.annual_income;
                    wPerson.height = warrantyPerson.height;
                    wPerson.weight = warrantyPerson.weight;
                    wPerson.area = warrantyPerson.area;
                    wPerson.address = warrantyPerson.address;
                    wPerson.start_time = warrantyPerson.start_time;
                    wPerson.end_time = warrantyPerson.end_time;
                    wPerson.record_start_time = warrantyPerson.start_time;
                    wPerson.record_end_time = 2145888000000L;
                    warrantyPersonList.add(wPerson);
                    lastId = warrantyPerson.id;

                }
                if (custWarrantyPersonService.insertAll(warrantyPersonList) == 0) {
                    return preLastId;
                }

            }

        } while (comPersonList != null && comPersonList.size() == limit);

        return lastId;
    }


    private String getUuid(Map<Long, String> cache, long personId) {
        if (cache.containsKey(personId)) {
            return cache.get(personId);
        } else {
            PersonRefer personRefer = personReferService.selectByOutPerson(personId);
            if (personRefer != null) {
                cache.put(personId, personRefer.account_uuid);
                return personRefer.account_uuid;
            } else {
                return null;
            }
        }
    }

    private Properties getProperties(){
        Properties prop = new Properties();

        try {
            File file  = new File(filePath);
            if(!file.exists()){
                file.createNewFile();

            }

            L.log.info("path {}",file.getAbsolutePath());


            InputStream in =  new BufferedInputStream(new FileInputStream(filePath));
            prop.load(in);     ///加载属性列表
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
    private void savePeroperties(Properties prop){

        try {
            FileOutputStream oFile = new FileOutputStream(filePath);
            prop.store(oFile,"update");
            oFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private long doBrokerage(long lastId){
        Page wPage = new Page();
        wPage.offset = limit;
        List<CustWarrantyCost> comCustWarranties = null;
        wPage.curTime = TimeKit.getDayStartTime();
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        do {
            wPage.lastId = lastId;
            comCustWarranties = custWarrantyCostService.selectPageValid(wPage);
            long preLastId = lastId;
            if (comCustWarranties != null && !comCustWarranties.isEmpty()) {
                List<CustWarrantyBrokerage> list = new ArrayList<>();
                for (CustWarrantyCost custWarrantyCost : comCustWarranties) {
                    CustWarrantyBrokerage brokerage = new CustWarrantyBrokerage();
                    String premium = custWarrantyCost.premium;
                    brokerage.cost_id = custWarrantyCost.id;

                    BigDecimal bigDecimal = new BigDecimal(premium);


                    brokerage.manager_money = decimalFormat.format(bigDecimal.multiply(new BigDecimal("0.49")).doubleValue());
                    brokerage.manager_rate = "0.49";
                    brokerage.ins_money = decimalFormat.format(bigDecimal.multiply(new BigDecimal("0.5")).doubleValue());
                    brokerage.ins_rate = "0.50";
                    brokerage.warranty_money = brokerage.ins_money;
                    brokerage.warranty_rate = "0.50";
                    brokerage.warranty_uuid = custWarrantyCost.warranty_uuid;
                    brokerage.manager_uuid = "14463303497682968";
                    brokerage.created_at = brokerage.updated_at = custWarrantyCost.created_at;
                    lastId = custWarrantyCost.id;
                    list.add(brokerage);
                }
                int all = custWarrantyBrokerageService.insertAll(list);
                if(all!=list.size()){
                    return preLastId;
                }

            }
        }while (comCustWarranties!=null && comCustWarranties.size()==limit);
        return lastId;
    }
}
