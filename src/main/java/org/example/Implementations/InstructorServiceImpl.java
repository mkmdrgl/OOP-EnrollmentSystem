package org.example.Implementations;

import org.example.Entities.Course;
import org.example.Entities.Instructor;
import org.example.Interfaces.IInstructorService;
import org.example.Exceptions.DuplicateIDExcep;
import java.util.ArrayList;
import java.util.Scanner;

public class InstructorServiceImpl implements IInstructorService{
    Scanner input = new Scanner(System.in);
    private ArrayList<Instructor> instructorList = new ArrayList<>();
    private String newCourseID;

    public void addInstructor(Instructor instructor) throws DuplicateIDExcep {
        for (Instructor inst : instructorList) {
            if (inst.getID().equals(instructor.getID())) {
                throw new DuplicateIDExcep("Error: Instructor ID " + instructor.getID() + " is already registered.");
            }
        }
        instructorList.add(instructor);
        System.out.println("Instructor " + instructor.getName() + " added successfully.");
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
                System.out.print("Enter the new course ID to assign: ");
                String newCourseID = input.nextLine();

                Course newCourseObject = new Course(newCourseID);
                instructorList.get(i).setCourse(newCourseObject);

                System.out.println("Instructor assigned successfully.");
                return;
            }
        }
        System.out.println("Instructor not found.");
    }

    public void displayAll() {
        System.out.println(instructorList);
    }

    public ArrayList<Instructor> getAllInstructors() {
        return instructorList;
    }

}