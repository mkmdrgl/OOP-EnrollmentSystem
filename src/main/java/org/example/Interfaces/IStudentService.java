package org.example.Interfaces;

import org.example.Entities.Student;
import org.example.Entities.Course;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayList;

public interface IStudentService {
    void addStudent(Student student);
    void updateStudent(String studentID);
    String removeStudent(String studentID);
    void displayAll();
}