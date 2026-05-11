package org.example.Interfaces;

import org.example.Entities.Instructor;
import java.util.ArrayList;
import java.util.Scanner;

public class IInstructorService {
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

}