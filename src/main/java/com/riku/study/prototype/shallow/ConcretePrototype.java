package com.riku.study.prototype.shallow;

import lombok.Data;

import java.util.List;

/**
 * 浅拷贝：实现Cloneable接口
 *
 * @author jay
 * @date 2020/02/29
 */
@Data
public class ConcretePrototype implements Cloneable {

    private int age;
    private String name;
    private List<String> hobbies;


    @Override
    protected ConcretePrototype clone() throws CloneNotSupportedException {
        return (ConcretePrototype) super.clone();
    }
}
