package com.riku.study.builder.simple;

/**
 * This is Description
 *
 * @author jay
 * @date 2020/02/29
 */
public class CourseBuilder {

    private Course course = new Course();

    public void addName(String name) {
        course.setName(name);
    }

    public void addPpt(String ppt) {
        course.setPpt(ppt);
    }

    public void addVideo(String video) {
        course.setVideo(video);
    }

    public Course builder() {
        return course;
    }

}
