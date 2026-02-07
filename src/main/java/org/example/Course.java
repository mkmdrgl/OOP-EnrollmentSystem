package org.example;

public class Course {
    private String courseID;
    private String courseName;
    private String program;

    public Course() {
    }

    public String getcourseID() {
        return courseID;
    }

    public String getcourseName() {
        return courseName;
    }

    public String getprogram() {
        return program;
    }

    public void setcourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setprogram(String program) {
        this.program = program;
    }

}