package cn.wean2016.mapper;

import cn.wean2016.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

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

    @Test
    public void testGetStudentByCondition(){
        Student studentModel = new Student();
//        studentModel.setStudentId("3116005189");
//        studentModel.setStudentName("%小%");
//        studentModel.setStudentGender(0);
        Integer pageSize = 2;
        Integer fromIndex= 1;

        List<Student> result = mapper.getStudentByCondition(studentModel, fromIndex, pageSize);
        Iterator<Student> it = result.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
