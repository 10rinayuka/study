package com.riku.study.proxy.general;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/01
 */
public class RealSubject implements ISubject {
    public void request() {
        System.out.println("Real request");
    }
}
