package com.riku.study.proxy.dynamicproxy.ljyproxy;

import java.lang.reflect.Method;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/03
 */
public interface LjyInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
