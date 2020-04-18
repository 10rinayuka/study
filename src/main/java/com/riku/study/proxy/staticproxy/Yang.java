package com.riku.study.proxy.staticproxy;

import com.riku.study.proxy.IPerson;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/01
 */
public class Yang implements IPerson {

    private Riku son;

    public Yang(Riku riku) {
        son = riku;
    }

    public void findLove() {
        System.out.println("开始物色");
        son.findLove();
        System.out.println("结束");
    }
}
