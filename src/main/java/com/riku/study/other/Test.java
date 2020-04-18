package com.riku.study.other;

import java.util.Arrays;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/04
 */
public class Test {

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }

    public static int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if (n % 2 == 1) count++;
            n = n /2;
        }

        return count;
    }

}
