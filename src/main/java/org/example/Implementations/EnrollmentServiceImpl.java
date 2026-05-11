package org.example.Implementations;

import org.example.Entities.Student;
import org.example.Entities.Section;
import org.example.Entities.Course;
import org.example.Entities.Department;
import org.example.Entities.Instructor;
import org.example.Exceptions.SectionFullExcep;
import org.example.Interfaces.IEnrollmentService;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentServiceImpl implements IEnrollmentService {
    private List<Student> studentList = new ArrayList<>();
    private List<Course> courseList = new ArrayList<>();
    private List<Instructor> instructorList = new ArrayList<>();

    public void enrollStudent(Student student, Section section) throws SectionFullExcep {
        if (section.getEnrolledStudents().size() >= section.getMaxCapacity()) {
            throw new SectionFullExcep("Registration failed: " + section.getSectionName() + " is full.");
        }

        section.getEnrolledStudents().add(student);
    }

    public void viewDepartmentHierarchy() {
        System.out.println("--- Department Hierarchy ---");

        for (Instructor inst : instructorList) {
            System.out.println("Instructor: " + inst.getName());

            Course currentCourse = inst.getCourse();
            if (currentCourse != null) {
                System.out.println("  Course: " + currentCourse.getCourseName());

                for (Student st : studentList) {
                    if (st.getEnrolledCourses().contains(currentCourse)) {
                        System.out.println("    - Student: " + st.getName());
                    }
                }
            }
            System.out.println();
        }
    }

    public void displayDepartmentHierarchy(Department department) {
        System.out.println("\n==========================================");
        System.out.println("DEPARTMENT: " + department.getDepartment());
        System.out.println("==========================================");

        if (department.getSections().isEmpty()) {
            System.out.println("   No sections registered in this department.");
        } else {
            for (Section section : department.getSections()) {
                System.out.println("\nSECTION: " + section.getSectionName());
                System.out.println("------------------------------------------");

                Instructor inst = section.getAssignedInstructor();
                if (inst != null) {
                    System.out.println("  ASSIGNED INSTRUCTOR: " + inst.getName());
                } else {
                    System.out.println("  ASSIGNED INSTRUCTOR: [No Instructor Assigned]");
                }

                System.out.println("  ENROLLED STUDENTS (" + section.getEnrolledStudents().size() + "/" + section.getMaxCapacity() + "):");
                if (section.getEnrolledStudents().isEmpty()) {
                    System.out.println("    - No students enrolled.");
                } else {
                    for (Student student : section.getEnrolledStudents()) {
                        System.out.println("    - [" + student.getID() + "] " + student.getName() + " (" + student.getProgram() + ")");
                    }
                }
            }
        }
        System.out.println("==========================================\n");
    }

}