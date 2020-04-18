package com.riku.study.proxy.dynamicproxy.cglibproxy;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/03
 */
public class Test {

    public static void main(String[] args) {

        CglibMeipo meipo = new CglibMeipo();
        IPerson riku = (IPerson) meipo.getInstance(Riku.class);
        riku.findLove();

        System.out.println("");
        IPerson jay = (IPerson) meipo.getInstance(Jay.class);
        jay.findLove();
        jay.buyInsure();
    }
}
