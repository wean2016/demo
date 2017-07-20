package cn.wean2016.service.serviceImpl;

import cn.wean2016.constant.Constant;
import cn.wean2016.domain.Course;
import cn.wean2016.domain.Student;
import cn.wean2016.mapper.CourseMapper;
import cn.wean2016.mapper.StudentMapper;
import cn.wean2016.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {




    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addStudent(Student student) {
        if (studentMapper.addStudent(student) == 1){
            return Constant.ADDSTUDENT_SUCCESSFUL;
        }
        return Constant.ADDSTUDENT_FAIL;
    }

    /**
     * 学生登陆
     * @param student 传入一个学生对象，里面包含传入的学生的 Id 和 Password
     * @return 若是账号密码正确，返回 LOGIN_SUCCESSFUL
     *          若是账号不存在，返回 ACCOUT_DOES_NOT_EXIT
     *          若是密码错误，返回 PASSWORD_WORING
     */
    public int signIn(Student student) {

        Student db_student = studentMapper.getStudentById(student.getStudentId());

        if (db_student == null) {
            return Constant.ACCOUT_DOES_NOT_EXIT;
        }else if (!student.getStudentPassword().equals(db_student.getStudentPassword())){
            return Constant.PASSWORD_WORING;
        }

        return Constant.LOGIN_SUCCESSFUL;
    }

    public Student getStudentInformation(String id) {
        return studentMapper.getStudentById(id);
    }

    public int updateStudentInformation(Student student) {
        return studentMapper.updateStudentInformation(student);
    }

    public List<Course> getStudentCourse(String id) {
        // TODO 获取学生课程
        return null;
    }

    public List<Course> getAllCourse() {
        return courseMapper.getAllCourse();
    }

    public int pickCourse() {
        // TODO 学生选课
        return 0;
    }
}
