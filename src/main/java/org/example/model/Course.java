package org.example.model;

public class Course {
    private String courseID;
    private String courseName;
    private String program;

    public Course() {
    }

    public Course(String courseID, String courseName, String program) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.program = program;
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

    public void display() {
        System.out.println("Course ID: " + getcourseID());
        System.out.println("Course Name: " + getcourseName());
        System.out.println("Course: " + getprogram());
    }

}