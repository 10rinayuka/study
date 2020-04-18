package com.riku.study.prototype.deep;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.List;

/**
 * 深拷贝：实现Cloneable接口，序列化实现深拷贝
 *
 * @author jay
 * @date 2020/02/29
 */
@Data
public class JsonPrototype implements Cloneable {

    private int age;
    private String name;
    private List<String> hobbies;

    /**
     * 浅拷贝
     *
     * @return
     */
    @Override
    public JsonPrototype clone() {
        try {
            return (JsonPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 深克隆：Json方式
     *
     * @return
     */
    public JsonPrototype deepClone() {
        String json = JSON.toJSONString(this);
        return JSON.parseObject(json, this.getClass());
    }


}
