package org.example;
import org.example.model.Student;
import org.example.model.Course;
import org.example.service.StudentEnrollment;
import org.example.service.CourseEnrollment;

public class Main {
    public static void main(String[] args) {

        StudentEnrollment studentEnrollment = new StudentEnrollment();

        studentEnrollment.addStudent(new Student("1", "John Doe", "BS Information Technology"));
        studentEnrollment.addStudent(new Student("2", "Jane Doe", "BS Information Technology"));

        studentEnrollment.displayAll();

        studentEnrollment.updateStudent(new Student("1", "John Doe", "BS Information Technology"));

        studentEnrollment.deleteStudent(new Student("2"));

        studentEnrollment.displayAll();

        CourseEnrollment courseEnrollment = new CourseEnrollment();

        courseEnrollment.addCourse(new Course("1", "Integrative Programming", "BS Information Technology"));
        courseEnrollment.addCourse(new Course("2", "Linux System", "BS Information Technology"));

        courseEnrollment.displayAll();

        courseEnrollment.updateCourse(new Course("2", "Linux System", "BS Information Technology"));

        courseEnrollment.deleteCourse(new Course("1"));

    }
}