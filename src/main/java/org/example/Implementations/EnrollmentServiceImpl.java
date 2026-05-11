package org.example.Implementations;

import org.example.Entities.Student;
import org.example.Entities.Section;
import org.example.Entities.Department;
import org.example.Entities.Instructor;
import org.example.Exceptions.SectionFullExcep;
import org.example.Interfaces.IEnrollmentService;

public class EnrollmentServiceImpl implements IEnrollmentService {
    public void enrollStudentInSection(Student student, Section section) throws SectionFullExcep {
        if (section.getEnrolledStudents().size() >= section.getMaxCapacity()) {
            String msg = "ERROR: " + section.getSectionName() + " is full (" + section.getMaxCapacity() + " max).";
            System.err.println(msg);
            throw new SectionFullExcep(msg);
        }

        section.getEnrolledStudents().add(student);
        System.out.println("Success: Enrolled " + student.getName() + " in " + section.getSectionName());
    }

    public void viewDepartmentHierarchy() {
    }

    public void displayDepartmentHierarchy(Department department) {
        if (department == null) {
            System.out.println("Error: Department is null.");
            return;
        }

        System.out.println("\nDEPARTMENT: " + department.getDepartment());
        for (Section section : department.getSections()) {
            System.out.println("  SECTION: " + section.getSectionName() +
                    " [" + section.getEnrolledStudents().size() + "/" + section.getMaxCapacity() + "]");

            Instructor inst = section.getAssignedInstructor();
            System.out.println("    Instructor: " + (inst != null ? inst.getName() : "TBA"));

            if (section.getEnrolledStudents().isEmpty()) {
                System.out.println("      - No students enrolled.");
            } else {
                for (Student s : section.getEnrolledStudents()) {
                    System.out.println("      - " + s.getName());
                }
            }
        }
    }
}