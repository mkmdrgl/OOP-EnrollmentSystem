package org.example.model;

public class Instructor extends Person {
    private String courses;

    public Instructor(int id, String name) {
        super(id, name);
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

}
