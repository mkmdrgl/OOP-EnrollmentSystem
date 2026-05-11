package org.example.Implementations;

import org.example.Entities.Student;
import org.example.Entities.Course;
import org.example.Entities.Instructor;
import org.example.Interfaces.IEnrollmentService;

import java.util.ArrayList;

public class EnrollmentServiceImpl implements IEnrollmentService {
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Course> courseList = new ArrayList<>();
    private ArrayList<Instructor> instructorList = new ArrayList<>();

    public void enrollStudentInSection(Student student, Course course) {
        student.getEnrolledCourses().add(course);
        System.out.println("Student " + student.getName() + " enrolled in " + course.getcourseName());
    }

    public void viewDepartmentHierarchy() {
        System.out.println("Department Hierarchy");

        for (Instructor inst : instructorList) {
            System.out.println("Instructor: " + inst.getName());

            if (inst.getCourse() != null) {
                Course currentCourse = inst.getCourse();
                System.out.println("  Course: " + currentCourse.getcourseName());

                for (Student st : studentList) {
                    if (st.getEnrolledCourses().contains(currentCourse)) {
                        System.out.println("    - Student: " + st.getName());
                    }
                }
            }
            System.out.println();
        }
    }

}