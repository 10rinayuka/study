package com.riku.study.singleton.hungry;

/**
 * 饿汉式单例
 *
 * @author jay
 * @date 2020/02/28
 */
public class HungrySingleton {
    /** 为什么要加 static final? */
//    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    /**
     *类加载顺序：
     * 先静态，后动态
     * 先上，后下
     * 先属性，后方法
     */
    private static final HungrySingleton hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton();
    }

    /**
     * 构造方法私有化
     */
    private HungrySingleton() {
    }

    /**
     * 通过getInstance获取已经实例化的实例
     *
     * @return
     */
    public HungrySingleton getInstance() {
        return hungrySingleton;

    }
}
