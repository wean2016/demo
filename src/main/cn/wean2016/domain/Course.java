package cn.wean2016.domain;

/**
 * Created by hasee on 2017/7/19.
 */
public class Course {
    private Teacher teacher;
    private String courseId;
    private String term;
    private String courseName;
    private double courseCredits;

    public Course() {
    }

    public Course(Teacher teacher, String courseId, String term, String courseName, double courseCredits) {
        this.teacher = teacher;
        this.courseId = courseId;
        this.term = term;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Course setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

    @Override
    public String toString() {
        return "Course{" +
                "teacher=" + teacher +
                ", courseId='" + courseId + '\'' +
                ", term='" + term + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseCredits=" + courseCredits +
                '}';
    }
}
