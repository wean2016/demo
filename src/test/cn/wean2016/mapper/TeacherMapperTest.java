package cn.wean2016.mapper;

import cn.wean2016.domain.Course;
import cn.wean2016.domain.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.ws.Service;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml", "classpath:springmvc.xml"})
public class TeacherMapperTest {

    @Autowired
    private TeacherMapper mapper;

    @Test
    public void testAddTeacher(){
        Teacher teacher = new Teacher("teacher233", "小哥哥", 0, "hahahahah", null, null);
        int result = mapper.addTeacher(teacher);
        System.out.println(result);
    }

    @Test
    public void testUpdateTeacher(){
        Teacher teacher = new Teacher("teacher222", "小姐姐", 1, "lalalala", "小姐姐的头像", null);
        int result = mapper.updateTeacher(teacher);
        System.out.println(result);
    }

    @Test
    public void testDeleteTeacher(){
        String teacherId = "teacher1234";
        int result = mapper.deleteTeacher(teacherId);
        System.out.println(result);
    }

    @Test
    public void testGetTeacherById(){
        String teacherId = "teacher222";
        System.out.println(mapper.getTeacherById(teacherId));
    }

    @Test
    public void testGetAllTeacher(){
        Iterator<Teacher> iterator = mapper.getAllTeacher().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


}
