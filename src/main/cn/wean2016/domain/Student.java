package cn.wean2016.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hasee on 2017/7/19.
 */
public class Student implements Serializable{

    @Pattern(regexp = "\\d{10}", message = "学号是 10 个数字！")       // 学号长度是 11 个数字
    private String studentId;

    @Pattern(regexp = "[\u4E00-\u9FA5]{2,3}", message = "姓名是两到三个汉字")     // 姓名是两到三个汉字
    private String studentName;

    @Range(min = 0, max = 1, message = "请选择性别！")
    @NotNull(message = "请选择性别！")
    private Integer studentGender;      // 0 代表男生， 1 代表女生
    @Pattern(regexp = "\\w{6,10}", message = "密码是 6 到 10 个字符（数字字母下划线）")
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
