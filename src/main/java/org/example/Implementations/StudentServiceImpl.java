package org.example.Implementations;

import org.example.Entities.Student;
import org.example.Interfaces.IStudentService;
import org.example.Exceptions.DuplicateIDExcep;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentServiceImpl implements IStudentService {
    private Scanner input = new Scanner(System.in);
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
        for (Student s : studentList) {
            if (s.getID().equals(studentID)) {
                System.out.print("Enter new name for student: ");
                s.setName(input.nextLine());
                System.out.print("Enter new program: ");
                s.setProgram(input.nextLine());
                System.out.println("Update successful.");
                return;
            }
        }
        throw new DuplicateIDExcep("Update failed: ID " + studentID + " not found.");
    }

    public String removeStudent(String studentID) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getID().equals(studentID)) {
                studentList.remove(i);
                return "Student " + studentID + " has been removed.";
            }
        }
        return "Error: Student not found";
    }

    public void displayAll() {
        if (studentList.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            System.out.println(studentList);
        }
    }

    public ArrayList<Student> getAllStudents() {
        return studentList;
    }
}