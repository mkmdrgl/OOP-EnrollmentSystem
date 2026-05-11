package org.example.Implementations;

import org.example.Entities.Student;
import org.example.Interfaces.IStudentService;
import org.example.Exceptions.DuplicateIDExcep;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentServiceImpl implements IStudentService {
    Scanner input = new Scanner(System.in);
    private ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) throws DuplicateIDExcep {
        for (Student s : studentList) {
            if (s.getID().equals(student.getID())) {
                throw new DuplicateIDExcep("Registration error: Student ID " + student.getID() + " already exists.");
            }
        }
        studentList.add(student);
        System.out.println("Student " + student.getID() + " added successfully.");
    }

    public void updateStudent(String studentID) throws DuplicateIDExcep {
        Student found = null;
        for (Student s : studentList) {
            if (s.getID().equals(studentID)) {
                found = s;
                break;
            }
        }

        if (found == null) {
            throw new DuplicateIDExcep("Update failed: ID " + studentID + " not found.");
        }

        System.out.println("Ready to update student: " + found.getName());
    }

    public String removeStudent(String studentID) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getID().equals(studentID)) {
                studentList.remove(i);
                return "Successfully Deleted";
            }
        }
        return "Error: Student not found";
    }

    public void displayAll() {
        System.out.println(studentList);
    }

    public ArrayList<Student> getAllStudents() {
        return studentList;
    }

}