package com.riku.study.singleton.lazy;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/02/26
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {

        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }


}
