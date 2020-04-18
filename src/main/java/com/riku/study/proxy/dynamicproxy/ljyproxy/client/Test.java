package com.riku.study.proxy.dynamicproxy.ljyproxy.client;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/03
 */
public class Test {

    public static void main(String[] args) {
        LjyMeipo meipo = new LjyMeipo();
        IPerson riku = meipo.getInstance(new Riku());
        riku.findLove();
        riku.buyInsure("重疾险", 500);

        IPerson jay = meipo.getInstance(new Jay());
        jay.findLove();
        jay.buyInsure("意外险", 430);

    }
}
