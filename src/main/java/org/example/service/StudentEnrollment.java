package org.example.service;
import org.example.model.Student;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentEnrollment {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Student> studentsList = new ArrayList<>();

    // Create
    public void addStudent(Student student) {
        studentsList.add(student);
    }

    // Read
    public void displayAll() {
        System.out.println(studentsList);
    }

}
