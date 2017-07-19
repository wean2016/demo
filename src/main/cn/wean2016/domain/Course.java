package cn.wean2016.domain;

/**
 * Created by hasee on 2017/7/19.
 */
public class Course {
    private String studentId;
    private String teacherId;
    private String courseId;
    private String term;
    private String courseName;
    private double courseCredits;
    private double courseGrade;

    public Course() {
    }

    public Course(String studentId, String teacherId, String courseId, String term, String courseName, double courseCredits, double courseGrade) {
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.term = term;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
        this.courseGrade = courseGrade;
    }

    public String getStudentId() {
        return studentId;
    }

    public Course setStudentId(String studentId) {
        this.studentId = studentId;
        return this;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public Course setTeacherId(String teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    public String getCourseId() {
        return courseId;
    }

    public Course setCourseId(String courseId) {
        this.courseId = courseId;
        return this;
    }

    public String getTerm() {
        return term;
    }

    public Course setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getCourseName() {
        return courseName;
    }

    public Course setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public double getCourseCredits() {
        return courseCredits;
    }

    public Course setCourseCredits(double courseCredits) {
        this.courseCredits = courseCredits;
        return this;
    }

    public double getCourseGrade() {
        return courseGrade;
    }

    public Course setCourseGrade(double courseGrade) {
        this.courseGrade = courseGrade;
        return this;
    }


    @Override
    public String toString() {
        return "Course{" +
                "studentId='" + studentId + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", term='" + term + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseCredits=" + courseCredits +
                ", courseGrade=" + courseGrade +
                '}';
    }
}
