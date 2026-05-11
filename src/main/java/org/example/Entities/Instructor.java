package org.example.Entities;

public class Instructor extends Person {
    private Course course;

    public Instructor(String instructorID, String instructorName) {
        super(instructorID, instructorName);
    }

    public Instructor(String instructorID, String instructorName, Course course) {
        super(instructorID, instructorName);
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course newCourse) {
        this.course = newCourse;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "ID='" + getID() + '\'' + // Added ID to toString
                ", name='" + getName() + '\'' +
                ", course=" + (course != null ? course.getcourseName() : "None") +
                '}';
    }
}