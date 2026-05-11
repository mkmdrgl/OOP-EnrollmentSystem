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

    public Student(String id, String name) {
        super(id, name);
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override
    public String toString() {
        return String.format("Student [ID: %s, Name: %s, Program: %s]",
                getID(), getName(), (program != null ? program : "Unassigned"));
    }
}