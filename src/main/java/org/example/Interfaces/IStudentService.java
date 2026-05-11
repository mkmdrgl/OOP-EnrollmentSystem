package org.example.Interfaces;

import org.example.Entities.Student;

public interface IStudentService {
    void addStudent(Student student);
    void updateStudent(String studentID);
    String removeStudent(String studentID);
    void displayAll();
}