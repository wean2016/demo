package cn.wean2016.constant;

public class Constant {
    public static final int LOGIN_SUCCESSFUL = 1;
    public static final int ACCOUT_DOES_NOT_EXIT = 0;
    public static final int PASSWORD_WORING = -1;
    public static final int ADDSTUDENT_SUCCESSFUL = 1;
    public static final int ADDSTUDENT_FAIL = -1;

    public static final String LOGIN_STATUS_PASSWORD_WORING = "您输入的密码不正确，请重试！";
    public static final String LOGIN_STATUS_ACCOUT_DOES_NOT_EXIT = "账号不存在，请重试！";

    public static final String STUDENT_STATUS_IN_SESSION = "student";
    public static final String TEACHER_STATUS_IN_SESSION = "teacher";
}
