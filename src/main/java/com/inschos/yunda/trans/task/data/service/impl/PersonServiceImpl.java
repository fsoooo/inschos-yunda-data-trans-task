package com.inschos.yunda.trans.task.data.service.impl;

import com.inschos.common.assist.kit.StringKit;
import com.inschos.yunda.trans.task.data.mapper.AccountMapper;
import com.inschos.yunda.trans.task.data.mapper.CustomerMapper;
import com.inschos.yunda.trans.task.data.mapper.PersonMapper;
import com.inschos.yunda.trans.task.data.mapper.PersonReferMapper;
import com.inschos.yunda.trans.task.data.service.PersonService;
import com.inschos.yunda.trans.task.model.Account;
import com.inschos.yunda.trans.task.model.Customer;
import com.inschos.yunda.trans.task.model.Person;
import com.inschos.yunda.trans.task.model.PersonRefer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
@Repository
public class PersonServiceImpl implements PersonService {

    private final long baseAccountUUid = 154000000000000L;

    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private PersonReferMapper personReferMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int insert(Person record) {
        return personMapper.insert(record);
    }

    @Override
    public List<PersonRefer> addAll(List<Person> list) {
        if(list==null || list.isEmpty()){
            return null;
        }
        int all = personMapper.insertAll(list);
        int size = list.size();
        if(all==size){
            List<Account> accountList = new ArrayList<>();
            List<PersonRefer> personRefers = new ArrayList<>();
            List<Customer> customers = new ArrayList<>();

            for (Person person : list) {
                Account account = new Account();
                String accountUuid = String.valueOf(baseAccountUUid + person.oldId);
                account.account_uuid = accountUuid;
                account.phone = person.phone;
                account.password = "";
                account.email = person.email;
                account.token = null;
                account.status = 1;
                account.sys_id = 1000;
                account.user_type = 1;
                account.user_id = String.valueOf(person.id);
                account.salt = StringKit.randStr(6);
                account.state = 1;
                account.origin = "YUNDA";
                account.created_at = person.created_at;
                account.updated_at = person.updated_at;
                accountList.add(account);

                PersonRefer personRefer = new PersonRefer();
                personRefer.account_uuid = accountUuid;
                personRefer.manager_uuid = "14463303497682968";
                personRefer.out_person_id = person.oldId;
                personRefer.person_id = person.id;
                personRefer.created_at = System.currentTimeMillis();
                personRefer.updated_at = System.currentTimeMillis();
                personRefers.add(personRefer);


                Customer customer = new Customer();
                customer.account_uuid = accountUuid;
                customer.customer_id = person.id;
                customer.created_at = person.created_at;
                customer.updated_at = person.updated_at;
                customer.manager_uuid = "14463303497682968";
                customer.type = 1;
                customers.add(customer);

            }
            if(accountMapper.insertAll(accountList)==size){
                if(personReferMapper.insertAll(personRefers)!=size){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return null;
                }else{

                    if(customerMapper.insertAll(customers)==size){
                        return personRefers;
                    }else{
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return null;
                    }

                }
            }else{
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return null;
            }
        }else{
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return null;

    }

    @Override
    public int update(Person update) {
        return personMapper.update(update);
    }

    @Override
    public Person findOne(long id) {
        return personMapper.selectOne(id);
    }
}
