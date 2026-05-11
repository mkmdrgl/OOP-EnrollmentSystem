<<<<<<< HEAD:src/main/java/org/example/Entities/Instructor.java
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
=======
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

    public void mainTask() {
        System.out.println("Main Task: Teach");
    }

}
>>>>>>> main:src/main/java/org/example/model/Instructor.java
