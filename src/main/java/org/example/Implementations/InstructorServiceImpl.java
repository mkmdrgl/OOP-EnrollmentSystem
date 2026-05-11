package org.example.Implementations;

import org.example.Entities.Instructor;
import org.example.Interfaces.IInstructorService;
import java.util.ArrayList;
import java.util.Scanner;

public class InstructorServiceImpl implements IInstructorService{
    Scanner input = new Scanner(System.in);
    private ArrayList<Instructor> instructorList = new ArrayList<>();

    public void addInstructor(Instructor instructor) {
        instructorList.add(instructor);
    }

    public void getInstructorDetails(String instructorID) {
        for (Instructor inst : instructorList) {
            if (inst.getID().equals(instructorID)) {
                System.out.println(inst);
                return;
            }
        }
        System.out.println("Instructor not found.");
    }

    public void assignInstructorToSection(String instructorID) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getID().equals(instructorID)) {
                System.out.print("Enter the new course/section to assign: ");
                String newCourse = input.nextLine();

                instructorList.get(i).setCourse(newCourse);

                System.out.println("Instructor assigned to " + newCourse + " successfully.");
                return;
            }
        }
        System.out.println("Instructor not found.");
    }

    public void displayAll() {
        System.out.println(instructorList);
    }

}