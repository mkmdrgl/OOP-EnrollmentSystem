package org.example.Implementations;

import org.example.Entities.Section;
import org.example.Entities.Instructor;
import org.example.Interfaces.IInstructorService;
import org.example.Exceptions.DuplicateIDExcep;
import java.util.ArrayList;
import java.util.Scanner;

public class InstructorServiceImpl implements IInstructorService {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Instructor> instructorList = new ArrayList<>();

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

    public void assignInstructorToSection(Instructor instructor, Section section) {
        if (instructor != null && section != null) {
            section.setAssignedInstructor(instructor);
            System.out.println("Assigned Instructor " + instructor.getName() +
                    " to Section " + section.getSectionName());
        } else {
            System.out.println("Error: Assignment failed. Instructor or Section is null.");
        }
    }

    public void updateInstructor(String instructorID) throws DuplicateIDExcep {
        for (Instructor inst : instructorList) {
            if (inst.getID().equals(instructorID)) {
                System.out.print("Enter new name for instructor: ");
                inst.setName(input.nextLine());

                System.out.println("Update successful.");
                return;
            }
        }
        throw new DuplicateIDExcep("Update failed: ID " + instructorID + " not found.");
    }

    public String removeInstructor(String instructorID) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getID().equals(instructorID)) {
                instructorList.remove(i);
                return "Instructor " + instructorID + " has been removed.";
            }
        }
        return "Error: Instructor not found";
    }

    public void displayAll() {
        if (instructorList.isEmpty()) {
            System.out.println("No instructors registered in the system.");
        } else {
            for (Instructor inst : instructorList) {
                System.out.println(inst);
            }
        }
    }

    public ArrayList<Instructor> getAllInstructors() {
        return instructorList;
    }
}