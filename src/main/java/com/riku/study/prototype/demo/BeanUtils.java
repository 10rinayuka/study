package com.riku.study.prototype.demo;

import java.lang.reflect.Field;

/**
 * 对象复制
 *
 * @author jay
 * @date 2020/03/01
 */
public class BeanUtils {

    public static Object copy(Object prototype) {
        Class clazz = prototype.getClass();
        Object ret = null;

        try {
            ret = clazz.newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                field.set(ret, field.get(prototype));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }
}
