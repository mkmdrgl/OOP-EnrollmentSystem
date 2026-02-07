package org.example;

public class Student {
    private int studentID;
    private String studentName;
    private String program;

    public Student() {
    }

    public int getstudentID() {
        return studentID;
    }

    public String getstudentName() {
        return studentName;
    }

    public String getprogram() {
        return program;
    }

    public void setstudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setstudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setprogram(String program) {
        this.program = program;
    }

}