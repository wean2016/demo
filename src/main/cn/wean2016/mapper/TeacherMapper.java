package cn.wean2016.mapper;

import cn.wean2016.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {

    public int addTeacher(Teacher teacher);

    public int updateTeacher(Teacher teacher);

    public int deleteTeacher(String teacherId);

    public Teacher getTeacherById(String teacherId);

    public List<Teacher> getAllTeacher();
}
