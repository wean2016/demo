package cn.wean2016.handlers;

import cn.wean2016.Util.UUIDUtil;
import cn.wean2016.constant.Constant;
import cn.wean2016.domain.Student;
import cn.wean2016.domain.Teacher;
import cn.wean2016.service.StudentService;
import cn.wean2016.service.TeacherService;
import com.alibaba.druid.support.spring.stat.SpringStatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.*;
import java.util.Map;
import java.util.UUID;

@Controller
public class LoginHandler {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;


    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String registIndex(Map<String, Object> map){
        map.put("student", new Student());
        return "regist";    // regist GET 方法直接转发到注册页面
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(@Valid Student student, Errors result, @RequestParam("avatar") MultipartFile avatar, HttpSession session){
        // 如果验证出错
        if (result.getErrorCount() > 0){
            return "regist";
        }


        String filename = avatar.getOriginalFilename();     // 上传的文件名字
        String suffix = filename.substring(filename.lastIndexOf("."));
        String name = UUID.randomUUID().toString().replaceAll("-", "");         // 保存在服务器上的名字
        String realPath = session.getServletContext().getRealPath("/avatar/")+"\\";
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(realPath + name + suffix);
                InputStream inputStream = avatar.getInputStream();){
            byte[] bbuf = new byte[1024];
            while (inputStream.read(bbuf) != -1){
                fileOutputStream.write(bbuf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String relativePath = "/avatar/" + name + suffix;

        student.setStudentAvatar(relativePath);

        studentService.addStudent(student);

        return "/studentSignIn";
    }

    /**
     * 登陆默认 model 是 student 类，这里只需要验证 ID 和 密码，其他属性将会给一个能通过登陆验证的值，不影响后续进行
     * @param map
     * @return
     */
    @RequestMapping(value = "/studentSignIn", method = RequestMethod.GET)
    public String studentSignIn(Map<String, Object> map){
        Student pattern = new Student();
        pattern.setStudentName("验证");
        pattern.setStudentGender(0);
        map.put("student", pattern);
        return "studentSignIn";
    }

    // 参数中的 session 用在 LoginAspect 切面中注册登陆信息
    @RequestMapping(value = "/studentSignIn", method = RequestMethod.POST)
    public String studentSignIn(@Valid Student student, Errors result, Map<String, Object> map, HttpSession session){

        if (result.getErrorCount() > 0){
            return "studentSignIn";
        }

        if (studentService.signIn(student) == Constant.ACCOUT_DOES_NOT_EXIT){
            map.put("loginStatus", Constant.LOGIN_STATUS_ACCOUT_DOES_NOT_EXIT);
            System.out.println(Constant.LOGIN_STATUS_ACCOUT_DOES_NOT_EXIT);
            return "studentSignIn";
        }else if ((studentService.signIn(student) == Constant.PASSWORD_WORING)){
            map.put("loginStatus", Constant.LOGIN_STATUS_PASSWORD_WORING);
            System.out.println(Constant.LOGIN_STATUS_PASSWORD_WORING);
            return "studentSignIn";
        }

        return "student/main";
    }

    /**
     * 登陆默认 model 是 teacher 类，这里只需要验证 ID 和 密码，其他属性将会给一个能通过登陆验证的值，不影响后续进行
     * @param map
     * @return
     */
    @RequestMapping(value = "/teacherSignIn", method = RequestMethod.GET)
    public String teacherSignIn(Map<String, Object> map){
        Teacher pattern = new Teacher();
        pattern.setTeacherName("验证");
        pattern.setTeacherGender(0);
        map.put("teacher", pattern);
        return "teacherSignIn";
    }

    // 参数中的 session 用在 LoginAspect 切面中注册登陆信息
    @RequestMapping(value = "/teacherSignIn", method = RequestMethod.POST)
    public String teacherSignIn(@Valid Teacher teacher, Errors result, Map<String, Object> map, HttpSession session){

        if (result.getErrorCount() > 0){
            return "teacherSignIn";
        }

        if (teacherService.signIn(teacher) == Constant.ACCOUT_DOES_NOT_EXIT){
            map.put("loginStatus", Constant.LOGIN_STATUS_ACCOUT_DOES_NOT_EXIT);
            System.out.println(Constant.LOGIN_STATUS_ACCOUT_DOES_NOT_EXIT);
            return "teacherSignIn";
        }else if ((teacherService.signIn(teacher) == Constant.PASSWORD_WORING)){
            map.put("loginStatus", Constant.LOGIN_STATUS_PASSWORD_WORING);
            System.out.println(Constant.LOGIN_STATUS_PASSWORD_WORING);
            return "teacherSignIn";
        }

        return "teacher/main";
    }
}
