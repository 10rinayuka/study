package com.riku.study.builder.chain;

import com.riku.study.builder.chain.CourseBuilder;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/02/29
 */
public class BuilderTest {
    public static void main(String[] args) {

        CourseBuilder builder = new CourseBuilder();
        builder.addName("Design Pattern").addPpt("ppt").addVideo("video");

        System.out.println(builder.builder());
    }
}
