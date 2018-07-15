package com.test;

import org.junit.Test;

import java.io.File;

/**
 * author   meiming_mm@163.com
 * date     2018/7/15
 * version  v1.0.0
 */
public class FileTest {

    @Test
    public void run(){
        File file = new File("/a.properties");
        System.out.println(file.getAbsolutePath());
    }
}
