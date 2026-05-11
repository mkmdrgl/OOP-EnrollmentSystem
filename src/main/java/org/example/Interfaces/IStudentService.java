package org.example.Interfaces;

import org.example.Entities.Student;
import java.util.Scanner;
import java.util.ArrayList;

public class IStudentService {
    Scanner input = new Scanner(System.in);
    private ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void updateStudent(String studentID) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getID().equals(studentID)) {

                System.out.print("Enter new name: ");
                String name = input.nextLine();

                System.out.print("Enter new program: ");
                String program = input.nextLine();

                studentList.get(i).getName(name);
                studentList.get(i).setprogram(program);

                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
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