package com.riku.study.proxy.staticproxy;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/01
 */
public class Test {
    public static void main(String[] args) {
        Yang mother = new Yang(new Riku());
        mother.findLove();
    }
}
