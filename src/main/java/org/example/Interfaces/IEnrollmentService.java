package org.example.Interfaces;

import org.example.Entities.Student;
import org.example.Entities.Section;
import org.example.Exceptions.SectionFullExcep;

public interface IEnrollmentService {
    void enrollStudent(Student student, Section section) throws SectionFullExcep;
    void viewDepartmentHierarchy();
}