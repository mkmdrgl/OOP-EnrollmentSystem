package org.example.Entities;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String program;
    private List<Course> enrolledCourses = new ArrayList<>();

    public Student() {
        super();
    }

    public Student(String studentID, String studentName, String program) {
        super(studentID, studentName);
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void setprogram(String program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "Student{" +
                "program='" + program + '\'' +
                ", enrolledCourses=" + enrolledCourses +
                '}';
    }

}