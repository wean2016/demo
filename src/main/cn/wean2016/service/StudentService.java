package cn.wean2016.service;

import cn.wean2016.domain.Course;
import cn.wean2016.domain.Student;

import java.util.List;

public interface StudentService {


    public int addStudent(Student student);

    public int signIn(Student student);

    public Student getStudentInformation(String id);

    public int updateStudentInformation(Student student);

    public List<Course> getStudentCourse(String id);

    public List<Course> getAllCourse();

    public int pickCourse();

}
