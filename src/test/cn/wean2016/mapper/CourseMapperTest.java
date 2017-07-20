package cn.wean2016.mapper;

import cn.wean2016.domain.Course;
import cn.wean2016.domain.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml", "classpath:springmvc.xml"})
public class CourseMapperTest {

    @Autowired
    private CourseMapper mapper;

    @Test
    public void testAddCourse(){
        Teacher teacher = new Teacher();
        teacher.setTeacherId("teacher233");
        Course course = new Course(teacher, "course66666", "2017年春季", "学习", 2);
        int result = mapper.addCourse(course);
        System.out.println(result);
    }

    @Test
    public void testUpdateCourse(){
        Teacher teacher = new Teacher();
        teacher.setTeacherId("teacher1234");
        Course course = new Course(teacher, "course12345", "2017年春季", "吃饭啦！", 2);
        int result = mapper.updateCourse(course);
        System.out.println(result);
    }

    @Test
    public void testDeleteCourse(){
        String courseId = "course12345";
        int result = mapper.deleteCourse(courseId);
        System.out.println(result);
    }

    @Test
    public void testGetCourseById(){
        String courseId = "course12345";
        Course course = mapper.getCourseById(courseId);
        System.out.println(course);
    }

    @Test
    public void testGetAllCourse(){
        System.out.println(mapper.getAllCourse());
    }
}
