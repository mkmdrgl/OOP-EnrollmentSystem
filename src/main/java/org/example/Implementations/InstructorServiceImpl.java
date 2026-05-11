package org.example.Implementations;

import org.example.Entities.Course;
import org.example.Entities.Instructor;
import org.example.Interfaces.IInstructorService;
import org.example.Exceptions.DuplicateIDExcep;
import java.util.ArrayList;
import java.util.Scanner;

public class InstructorServiceImpl implements IInstructorService {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Instructor> instructorList = new ArrayList<>();

    @Override
    public void addInstructor(Instructor instructor) throws DuplicateIDExcep {
        for (Instructor inst : instructorList) {
            if (inst.getID().equals(instructor.getID())) {
                throw new DuplicateIDExcep("Error: Instructor ID " + instructor.getID() + " is already registered.");
            }
        }
        instructorList.add(instructor);
        System.out.println("Instructor " + instructor.getName() + " added successfully.");
    }

    @Override
    public void getInstructorDetails(String instructorID) {
        for (Instructor inst : instructorList) {
            if (inst.getID().equals(instructorID)) {
                System.out.println(inst);
                return;
            }
        }
        System.out.println("Instructor not found.");
    }

    @Override
    public void assignInstructorToSection(String instructorID) {
        for (Instructor inst : instructorList) {
            if (inst.getID().equals(instructorID)) {
                System.out.print("Enter the new course ID: ");
                String newCourseID = input.nextLine();
                System.out.print("Enter the course name: ");
                String newCourseName = input.nextLine();

                Course newCourse = new Course(newCourseID, newCourseName);
                inst.setCourse(newCourse);

                System.out.println("Course " + newCourseName + " assigned to Instructor " + inst.getName());
                return;
            }
        }
        System.out.println("Instructor ID " + instructorID + " not found.");
    }

    @Override
    public void displayAll() {
        if (instructorList.isEmpty()) {
            System.out.println("No instructors registered in the system.");
        } else {
            for (Instructor inst : instructorList) {
                System.out.println(inst);
            }
        }
    }
}