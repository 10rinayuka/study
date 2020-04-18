package com.riku.study.builder.chain;

import lombok.Data;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/02/29
 */
@Data
public class Course {

    private String name;
    private String ppt;
    private String video;

    public String toString() {
        return "name = " + name + "ppt = " + ppt + "video = " + video;
    }

}
