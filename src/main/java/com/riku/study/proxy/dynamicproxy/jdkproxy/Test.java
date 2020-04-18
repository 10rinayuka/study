package com.riku.study.proxy.dynamicproxy.jdkproxy;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/03
 */
public class Test {

    public static void main(String[] args) {
        JdkMeipo meipo = new JdkMeipo();
        IPerson riku = meipo.getInstance(new Riku());
        riku.findLove();

        IPerson jay = meipo.getInstance(new Jay());
        jay.findLove();
        jay.buyInsure();
    }
}
