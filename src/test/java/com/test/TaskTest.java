package com.test;

import com.inschos.yunda.trans.task.task.TaskDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * author   meiming_mm@163.com
 * date     2018/7/15
 * version  v1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
@TestPropertySource({"classpath:/config.properties"})
public class TaskTest {

    @Autowired
    private TaskDo taskDo;

    @Test
    public void run(){
        taskDo.testDo();
    }
}
