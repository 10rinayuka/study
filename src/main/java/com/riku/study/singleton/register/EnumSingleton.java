package com.riku.study.singleton.register;

/**
 * 枚举式单例
 * 1. 枚举类型不能被反射
 * 2. 枚举类型声明的时候已经创建实例，没有线程安全问题
 * 3. 创建的枚举实例会放入枚举容器中，所以属于注册式单例：某些情况下会造成内存浪费
 *
 * @author jay
 * @date 2020/02/26
 */
public enum  EnumSingleton {

    INSTANCE;

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
