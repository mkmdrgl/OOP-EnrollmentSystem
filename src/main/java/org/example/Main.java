package org.example;
import org.example.model.Student;
import org.example.model.Course;
import org.example.service.StudentEnrollment;

public class Main {
    public static void main(String[] args) {

        // Student Enrollment
        StudentEnrollment studentEnrollment = new StudentEnrollment();

        // Create
        studentEnrollment.addStudent(new Student("1", "John Doe", "BS Information Technology"));
        studentEnrollment.addStudent(new Student("2", "Jane Doe", "BS Information Technology"));

        // Read
        studentEnrollment.displayAll();

        // Update
        studentEnrollment.updateStudent(new Student("1", "John Doe", "BS Information Technology"));

        // Remove
        studentEnrollment.deleteStudent(new Student("2"));

        studentEnrollment.displayAll();

    }
}