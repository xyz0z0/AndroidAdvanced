package xyz.xyz0z0.androidadvanced.c02;

import java.io.Serializable;

/**
 * Author: Cheng
 * Date: 2021/6/1 8:52
 * Description: xyz.xyz0z0.androidadvanced.c02
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 8483518345465923315L;

    private String teacher;


    public Student(String teacher) {
        this.teacher = teacher;
    }


    public String getTeacher() {
        return teacher;
    }


    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }


    @Override public String toString() {
        return "Student{" +
            "teacher='" + teacher + '\'' +
            '}';
    }
}
