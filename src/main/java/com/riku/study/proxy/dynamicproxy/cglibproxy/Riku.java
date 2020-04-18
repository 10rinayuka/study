package com.riku.study.proxy.dynamicproxy.cglibproxy;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/03
 */
public class Riku implements IPerson {
    @Override
    public void buyInsure() {
        System.out.println("buy 100w");
    }

    @Override
    public void findLove() {
        System.out.println("tall beauty cosplay");
    }
}
