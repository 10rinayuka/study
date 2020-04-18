package com.riku.study.singleton.lazy;

/**
 * 懒汉式 双重检查式 单例
 * 检查是否阻塞
 * 检查是否null，需要创建实例
 *
 * volatile: 解决指令重排序问题
 *
 * @author jay
 * @date 2020/02/28
 */
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton instance;

    private LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new LazyDoubleCheckSingleton();
                }
            }
        }

        return instance;
    }
}
