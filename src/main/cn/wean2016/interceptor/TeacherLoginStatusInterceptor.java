package cn.wean2016.interceptor;

import cn.wean2016.constant.Constant;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TeacherLoginStatusInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        String status = (String) session.getAttribute("status");
        String id = (String) session.getAttribute("id");

        if (status == null) {
            return false;   // 未登陆
        }else if (!status.equals(Constant.TEACHER_STATUS_IN_SESSION)){
            return false;   //  登陆状态不是学生
        }else if (id == null) {
            return false;   // 没有 id 记录
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
