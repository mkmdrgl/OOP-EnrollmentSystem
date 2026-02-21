package org.example.model;

public class Student {
    private String studentID;
    private String studentName;
    private String program;

    public Student() {
    }

    public Student(String studentID, String studentName, String program) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.program = program;
    }

    public String getstudentID() {
        return studentID;
    }

    public String getstudentName() {
        return studentName;
    }

    public String getprogram() {
        return program;
    }

    public void setstudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setstudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setprogram(String program) {
        this.program = program;
    }

    public void display() {
        System.out.println("Student ID: " + getstudentID());
        System.out.println("Student Name: " + getstudentName());
        System.out.println("Program: " + getprogram());
    }
}