package org.example.Interfaces;

import org.example.Entities.Student;
import org.example.Entities.Course;

public interface IEnrollmentService {
    void enrollStudentInSection(Student student, Course course);
    void viewDepartmentHierarchy();
}