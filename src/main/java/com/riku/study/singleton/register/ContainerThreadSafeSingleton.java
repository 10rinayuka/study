package com.riku.study.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/02/26
 */
public class ContainerThreadSafeSingleton {

    private ContainerThreadSafeSingleton() {
    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getInstance(String className) {

        if (!ioc.containsKey(className)) {
            try {
                synchronized (ContainerThreadSafeSingleton.class) {
                    if (!ioc.containsKey(className)) {
                        Object instance = Class.forName(className).newInstance();
                        ioc.put(className, instance);
                        return instance;
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return ioc.get(className);

    }

}
