package cn.wean2016.service.serviceImpl;

import cn.wean2016.constant.Constant;
import cn.wean2016.domain.Course;
import cn.wean2016.domain.Student;
import cn.wean2016.domain.Teacher;
import cn.wean2016.mapper.CourseMapper;
import cn.wean2016.mapper.TeacherMapper;
import cn.wean2016.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public int signIn(Teacher teacher) {
        Teacher db_teacher = teacherMapper.getTeacherById(teacher.getTeacherId());

        Teacher db_teacher1 = db_teacher;
        if (db_teacher1 == null) {
            return Constant.ACCOUT_DOES_NOT_EXIT;
        }else if (!teacher.getTeacherPassword().equals(db_teacher.getTeacherPassword())){
            return Constant.PASSWORD_WORING;
        }

        return Constant.LOGIN_SUCCESSFUL;
    }

    @Override
    public Teacher getTeacherInformation(String id) {
        return teacherMapper.getTeacherById(id);
    }

    @Override
    public int publishCourse(Course course) {
        int result = courseMapper.addCourse(course);
        if (result == Constant.ADD_COURSE_SUCCESSFUL){
            return Constant.ADD_COURSE_SUCCESSFUL;
        }
        return Constant.ADD_COURSE_FAIL;
    }


}
