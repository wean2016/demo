package cn.wean2016.mapper;

import cn.wean2016.domain.Course;
import javafx.scene.input.PickResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {

    public int addCourse(Course course);

    public int updateCourse(Course course);

    public int deleteCourse(String courseId);

    public Course getCourseById(String courseId);

    public List<Course> getAllCourse();



}
