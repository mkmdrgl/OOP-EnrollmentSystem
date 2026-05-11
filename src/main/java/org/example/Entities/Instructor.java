package org.example.Entities;

public class Instructor extends Person {
    private String course;

    public Instructor() {
        super();
    }

    public Instructor(String instructorID, String instructorName, String course) {
        super(instructorID, instructorName);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse() {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "course='" + course + '\'' +
                '}';
    }

}
