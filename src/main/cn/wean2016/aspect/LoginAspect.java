package cn.wean2016.aspect;

import cn.wean2016.constant.Constant;
import cn.wean2016.domain.Student;
import cn.wean2016.domain.Teacher;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

public class LoginAspect {



    public String studentLoginAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        // 获得拦截业务方法的参数
        Object[] args = proceedingJoinPoint.getArgs();
        Student student = (Student) args[0];        // 获得用户输入的信息
        HttpSession session = (HttpSession) args[3];        // 获得 session
        String result = null;   // 用来接收业务方法的返回值
        try {
            // 执行业务方法，也可以使用无参数，返回值就是业务方法的返回值
            result = (String) proceedingJoinPoint.proceed(args);
        } catch (Throwable e){
            e.printStackTrace();
        }
        // 该业务方法是验证账号密码，若是正确将会返回 "student/main"
        // 若是返回该值，则在 session 中写入学生状态，和学生 id
        if (result.equals("student/main")){
            session.setAttribute("status", Constant.STUDENT_STATUS_IN_SESSION);
            session.setAttribute("id", student.getStudentId());
        }

        return result;
    }

    public String teacherLoginAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        // 获得拦截业务方法的参数
        Object[] args = proceedingJoinPoint.getArgs();
        Teacher teacher = (Teacher) args[0];        // 获得用户输入的信息
        HttpSession session = (HttpSession) args[3];        // 获得 session
        String result = null;   // 用来接收业务方法的返回值
        try {
            // 执行业务方法，也可以使用无参数，返回值就是业务方法的返回值
            result = (String) proceedingJoinPoint.proceed(args);
        } catch (Throwable e){
            e.printStackTrace();
        }
        // 该业务方法是验证账号密码，若是正确将会返回 "student/main"
        // 若是返回该值，则在 session 中写入学生状态，和学生 id
        if (result.equals("teacher/main")){
            session.setAttribute("status", Constant.TEACHER_STATUS_IN_SESSION);
            session.setAttribute("id", teacher.getTeacherId());
        }

        return result;
    }
}
