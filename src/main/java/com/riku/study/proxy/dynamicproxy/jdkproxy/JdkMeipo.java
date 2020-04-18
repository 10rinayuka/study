package com.riku.study.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/03
 */
public class JdkMeipo implements InvocationHandler {

    private IPerson person;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object ret = method.invoke(this.person, args);
        after();

        return ret;
    }

    private void after() {
        System.out.println("After: 完成");
    }

    private void before() {
        System.out.println("Before: 需求");
    }

    public IPerson getInstance(IPerson person) {
        this.person = person;
        Class clazz = person.getClass();


        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }
}
