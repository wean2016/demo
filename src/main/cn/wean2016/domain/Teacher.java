package cn.wean2016.domain;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hasee on 2017/7/19.
 */
public class Teacher {
    private String teacherId;
    private String teacherName;
    private Integer teacherGender;
    private String teacherPassword;
    private String teacherAvatar;
    private List<Course> courses;

    public Teacher() {
    }

    public Teacher(String teacherId, String teacherName, Integer teacherGender, String teacherPassword, String teacherAvatar, List<Course> courses) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherGender = teacherGender;
        this.teacherPassword = teacherPassword;
        this.teacherAvatar = teacherAvatar;
        this.courses = courses;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public Teacher setTeacherId(String teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public Teacher setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        return this;
    }

    public Integer getTeacherGender() {
        return teacherGender;
    }

    public Teacher setTeacherGender(Integer teacherGender) {
        this.teacherGender = teacherGender;
        return this;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public Teacher setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
        return this;
    }

    public String getTeacherAvatar() {
        return teacherAvatar;
    }

    public Teacher setTeacherAvatar(String teacherAvatar) {
        this.teacherAvatar = teacherAvatar;
        return this;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Teacher setCourses(List<Course> courses) {
        this.courses = courses;
        return this;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherGender=" + teacherGender +
                ", teacherPassword='" + teacherPassword + '\'' +
                ", teacherAvatar='" + teacherAvatar + '\'' +
                ", courses=" + courses +
                '}';
    }
}
