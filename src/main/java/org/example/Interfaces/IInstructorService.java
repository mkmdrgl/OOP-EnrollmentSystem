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

}