package org.example.Interfaces;

import org.example.Entities.Student;
import org.example.Entities.Course;
import org.example.Entities.Instructor;
import java.util.ArrayList;

public class IEnrollmentService {
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Course> courseList = new ArrayList<>();
    private ArrayList<Instructor> instructorList = new ArrayList<>();

    public void enrollStudentInSection(Student student, Course course) {
        student.getEnrolledCourses().add(course);
        System.out.println("Student " + student.getName() + " enrolled in " + course.getcourseName());
    }

}