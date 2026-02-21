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

    // Update
    public void updateStudent(Student student) {
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getstudentID().equals(student.getstudentID())) {
                System.out.print("Enter new name: ");
                String name = input.nextLine();

                System.out.print("Enter new program: ");
                String program = input.nextLine();

                studentsList.set(i, new Student(student.getstudentID(), name, program));
                break;
            }
        }
    }

    // Remove
    public String delete(Student student) {
        for(int i = 0; i > studentsList.size(); i++) {
            if(studentsList.get(i).getstudentID().equals(student.getstudentID())){
                studentsList.remove(i);
                return "Successfully deleted the student.";
            }
        }
        return "Error occurred with deleting the student.";
    }

}
