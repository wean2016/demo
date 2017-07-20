package cn.wean2016.mapper;

import cn.wean2016.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hasee on 2017/7/19.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml","classpath:springmvc.xml"})
public class StudentMapperTest {

    @Autowired
    private StudentMapper mapper;

    @Test
    public void testAddStudent(){
        mapper.addStudent(new Student("3116005180", "刘跃群", 0, "ASDFGHJKL", "test"));
    }


    @Test
    public void testGetStudentById(){
        Student student = mapper.getStudentById("3116005189");
        System.out.println(student);
    }

    @Test
    public void testGetAllStudent(){
        System.out.println(mapper.getAllStudent());
    }

    @Test
    public void testUpdateStudent(){
        Student student = mapper.getStudentById("3116005189");
        student.setStudentName("pap");
        int result = mapper.updateStudentInformation(student);
        System.out.println(result);
    }

    @Test
    public void testDeleteStudent(){
        int result = mapper.deleteStudent("3116005180");
        System.out.println(result);
    }
}
