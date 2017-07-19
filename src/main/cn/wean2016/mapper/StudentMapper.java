package cn.wean2016.mapper;

import cn.wean2016.domain.Student;
import javafx.scene.media.VideoTrack;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hasee on 2017/7/19.
 */
@Component
public interface StudentMapper {

    public Student getStudentById(String id);
    public List<Student> getAllStudent();
    public int updateStudentInformation(Student student);
    public int addStudent(Student student);
    public int deleteStudent(int id);

}
