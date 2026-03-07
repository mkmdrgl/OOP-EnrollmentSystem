package org.example.model;

public class Student extends Person{
    private String program;

    public Student(int id, String name) {
        super(id, name);
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

}