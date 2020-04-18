package com.riku.study.singleton.lazy;

/**
 * 为什么是懒汉式
 * 类加载机制：内部类只在
 *
 * @author jay
 * @date 2020/02/26
 */
public class LazyStaticInnerClassSingleton {

    private LazyStaticInnerClassSingleton() {
        /**
         * 防止反射破坏：反射机制调用构造函数，如果有既存实例，报错
         */
        if (LazyHandler.INSTANCE != null) {
            throw new RuntimeException("test");
        }
    }

    public static LazyStaticInnerClassSingleton getInstance() {
        return LazyHandler.INSTANCE;
    }

    /**
     * 内部类的特性
     */
    private static class LazyHandler {
        private static final LazyStaticInnerClassSingleton INSTANCE = new LazyStaticInnerClassSingleton();
    }
}
