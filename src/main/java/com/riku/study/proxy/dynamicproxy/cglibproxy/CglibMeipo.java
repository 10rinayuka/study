package com.riku.study.proxy.dynamicproxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/03
 */
public class CglibMeipo implements MethodInterceptor {

    private void after() {
        System.out.println("After: 完成");
    }

    private void before() {
        System.out.println("Before: 需求");
    }

    public Object getInstance(Class clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object ret = methodProxy.invokeSuper(o, objects);
        after();
        return ret;
    }
}
