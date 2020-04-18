package com.riku.study.singleton.serializable;

import java.io.Serializable;

/**
 * 序列化单例Demo
 *
 * @author jay
 * @date 2020/02/26
 */
public class SerializableSingleton implements Serializable {

    // 序列化
    /**
     * 把内存中对象的状态
     */

    // 反序列化


    public final static  SerializableSingleton INSTANCE = new SerializableSingleton();
    private SerializableSingleton(){}

    public static SerializableSingleton getInstance() {
        return INSTANCE;
    }

    /**
     * 解决序列化/反序列化破坏单例模式
     */
    private Object readResolve() {
        return INSTANCE;
    }
}
