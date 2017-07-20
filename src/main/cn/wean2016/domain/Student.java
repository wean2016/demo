package cn.wean2016.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hasee on 2017/7/19.
 */
public class Student implements Serializable{

    private String studentId;
    private String studentName;
    private Integer studentGender;      // 0 代表男生， 1 代表女生
    private String studentPassword;
    private String studentAvatar;

    public Student() {
    }

    public Student(String studentId, String studentName, Integer studentGender, String studentPassword, String studentAvatar) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentPassword = studentPassword;
        this.studentAvatar = studentAvatar;
    }

    public String getStudentId() {
        return studentId;
    }

    public Student setStudentId(String studentId) {
        this.studentId = studentId;
        return this;
    }

    public String getStudentName() {
        return studentName;
    }

    public Student setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public Integer getStudentGender() {
        return studentGender;
    }

    public Student setStudentGender(Integer studentGender) {
        this.studentGender = studentGender;
        return this;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public Student setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
        return this;
    }

    public String getStudentAvatar() {
        return studentAvatar;
    }

    public Student setStudentAvatar(String studentAvatar) {
        this.studentAvatar = studentAvatar;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentGender=" + studentGender +
                ", studentPassword='" + studentPassword + '\'' +
                ", studentAvatar='" + studentAvatar + '\'' +
                '}';
    }
}
