package cn.wean2016.service.serviceImpl;

import cn.wean2016.domain.Course;
import cn.wean2016.domain.Student;
import cn.wean2016.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml", "classpath:springmvc.xml"})
public class StudentServiceImplTest {

    @Autowired
    private StudentService service;

    @Test
    public void testSignIn(){
        Student testStudent = new Student();
        testStudent.setStudentId("3116005188");
        testStudent.setStudentPassword("qwertyuiop");
        int result = service.signIn(testStudent);

        if (result == -1){
            System.out.println("PASSWORD_WORING");
        }else if(result == 0 ){
            System.out.println("ACCOUT_DOES_NOT_EXIT");
        }else if (result == 1){
            System.out.println("LOGIN_SUCCESSFUL");
        }else {
            throw new RuntimeException("登陆测试错误！");
        }
    }

    @Test
    public void testGetStudentInformation(){
        System.out.println(service.getStudentInformation("3116005189"));
    }

    @Test
    public void testUpdateStudentInformation(){
        Student student = service.getStudentInformation("3116005189");
        student.setStudentAvatar("avatar");
        int result = service.updateStudentInformation(student);
        System.out.println(result);
    }

    @Test
    public void testGetAllCourse(){
        List<Course> courses = service.getAllCourse();

        for (Course course : courses){
            System.out.println(course);
        }
    }
}
