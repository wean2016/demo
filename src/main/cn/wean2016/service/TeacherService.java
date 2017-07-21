package cn.wean2016.service;

import cn.wean2016.domain.Teacher;

import java.util.List;

public interface TeacherService {

    public int signIn(Teacher teacher);

    public Teacher getTeacherInformation(String id);


}
