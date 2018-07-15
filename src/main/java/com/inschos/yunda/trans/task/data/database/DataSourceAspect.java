package com.inschos.yunda.trans.task.data.database;

import com.inschos.common.assist.kit.L;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * author   meiming_mm@163.com
 * date     2018/7/14
 * version  v1.0.0
 */
public class DataSourceAspect {


    public void before(JoinPoint point)
    {

        L.log.info("数据源的获取 DataSource: ");
        Object target = point.getTarget();// 拦截的实体类
        String method = point.getSignature().getName();// 拦截的方法名称
        Class<?>[] classz = target.getClass().getInterfaces();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
                .getMethod().getParameterTypes();// 拦截的方法参数类型
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource data = m
                        .getAnnotation(DataSource.class);
                DataSourceHolder.setDataSource(data.value());
                L.log.info("数据源的获取 DataSource: "+data.value());
            }else if(classz[0].isAnnotationPresent(DataSource.class)){
                DataSource data = classz[0].getAnnotation(DataSource.class);
                DataSourceHolder.setDataSource(data.value());
                L.log.info("数据源的获取 DataSource: "+data.value());
            }

        } catch (Exception e) {
            L.log.error("数据源的获取 aop实现 出错："+e.getMessage());
        }
    }

}
