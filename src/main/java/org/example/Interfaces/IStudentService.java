package org.example.Interfaces;

import org.example.Entities.Student;
import org.example.Exceptions.DuplicateIDExcep;

public interface IStudentService {
    void addStudent(Student student) throws DuplicateIDExcep;
    void updateStudent(String studentID) throws DuplicateIDExcep;
    String removeStudent(String studentID);
    void displayAll();
}