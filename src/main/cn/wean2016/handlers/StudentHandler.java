package cn.wean2016.handlers;

import cn.wean2016.constant.Constant;
import cn.wean2016.domain.Student;
import cn.wean2016.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/student")
public class StudentHandler {

    @Autowired
    private StudentService studentService;

    @ModelAttribute
    public void getInfomation(HttpSession session, Map<String, Object> map){
        Student student = studentService.getStudentInformation((String) session.getAttribute("id"));
        map.put("student", student);
    }

    @RequestMapping(value = "/information", method = RequestMethod.GET)
    public String updateInformation(HttpSession session, Map<String, Object> map){
        Student student = studentService.getStudentInformation((String) session.getAttribute("id"));    // 获得当前账号信息
        map.put("student", student);
        return "/student/information";
    }

    @RequestMapping(value = "/updateAvatar")
    public String updateAvatar(Student student, MultipartFile avatar,HttpSession session){
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

        studentService.updateStudentInformation(student);

        return "redirect:/student/information";
    }

    @RequestMapping(value = "/information",method = RequestMethod.POST)
    public String updateInformation(@Valid Student student, Errors result, Map<String, Object> map){
        if (result.getErrorCount() > 0){
            return "/student/information";
        }

        studentService.updateStudentInformation(student);
        map.put("updateStatus", Constant.UPDATE_SUCCESSFUL);
        return "/student/information";
    }

    @RequestMapping("main")
    public String main(){
        return "/student/main";
    }

}
