package cn.wean2016.handlers;

import cn.wean2016.Util.UUIDUtil;
import cn.wean2016.constant.Constant;
import cn.wean2016.domain.Student;
import cn.wean2016.service.StudentService;
import com.alibaba.druid.support.spring.stat.SpringStatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Map;
import java.util.UUID;

@Controller
public class LoginHandler {

    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String registIndex(){
        return "regist";    // regist GET 方法直接转发到注册页面
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(Student student, @RequestParam("avatar") MultipartFile avatar, HttpSession session){
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

        System.out.println(student);

        studentService.addStudent(student);

        return "/signIn";
    }

    @RequestMapping("/signIn")
    public String signIn(Map<String, Object> map){
        map.put("student", new Student());
        return "signIn";
    }

    @RequestMapping("/studentSignIn")
    public String studentSignIn(Student student){

        if (studentService.signIn(student) == Constant.ACCOUT_DOES_NOT_EXIT){
            return "signIn";
        }else if ((studentService.signIn(student) == Constant.PASSWORD_WORING)){
            return "signIn";
        }

        return "student/main";
    }
}
