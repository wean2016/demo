package cn.wean2016.domain;

public class Score {

    private Course course;
    private Student student;
    private double score;

    public Score() {
    }

    public Score(Course course, Student student, double score) {
        this.course = course;
        this.student = student;
        this.score = score;
    }

    public Course getCourse() {
        return course;
    }

    public Score setCourse(Course course) {
        this.course = course;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public Score setStudent(Student student) {
        this.student = student;
        return this;
    }

    public double getScore() {
        return score;
    }

    public Score setScore(double score) {
        this.score = score;
        return this;
    }

    @Override
    public String toString() {
        return "Score{" +
                "course=" + course +
                ", student=" + student +
                ", score=" + score +
                '}';
    }
}
