package com.riku.study.proxy.dynamicproxy.ljyproxy.client;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/03
 */
public class Riku implements IPerson {
    @Override
    public void buyInsure(String type, int amount) {
        System.out.println("买了" + type + ": 价格为" + amount);
    }

    @Override
    public void findLove() {
        System.out.println("tall beauty cosplay");
    }
}
