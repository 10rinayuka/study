package com.riku.study.proxy.dynamicproxy.jdkproxy;


/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/03
 */
public class Jay implements IPerson {
    @Override
    public void buyInsure() {
        System.out.println("buy 30w");
    }

    @Override
    public void findLove() {
        System.out.println("glasses cute");
    }
}
