package org.example.Entities;

public class Instructor extends Person {
    private Course course;

    public Instructor(String id, String name) {
        super(id, name);
    }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    @Override
    public String toString() {
        return String.format("Instructor [ID: %s, Name: %s, Assigned Course: %s]",
                getID(), getName(), (course != null ? course.getCourseName() : "None"));
    }
}