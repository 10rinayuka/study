package com.riku.study.proxy.dynamicproxy.ljyproxy.client;

import com.riku.study.proxy.dynamicproxy.ljyproxy.LjyClassLoader;
import com.riku.study.proxy.dynamicproxy.ljyproxy.LjyInvocationHandler;
import com.riku.study.proxy.dynamicproxy.ljyproxy.LjyProxy;

import java.lang.reflect.Method;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/03
 */
public class LjyMeipo implements LjyInvocationHandler {

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


        return (IPerson) LjyProxy.newProxyInstance(new LjyClassLoader(), clazz.getInterfaces(), this);
    }
}
