package com.riku.study.prototype;

import com.riku.study.prototype.deep.JsonPrototype;

import java.util.ArrayList;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/03/01
 */
public class PrototypeTest {

    public static void main(String[] args) {
        JsonPrototype prototype = new JsonPrototype();
        prototype.setAge(18);
        prototype.setName("riku");
        prototype.setHobbies(new ArrayList<String>());
        prototype.getHobbies().add("coding");
        prototype.getHobbies().add("game");

        JsonPrototype clone = prototype.deepClone();
        clone.getHobbies().add("fishing");

        System.out.println("proto: " + prototype);
        System.out.println("clone: " + clone);
    }
}
