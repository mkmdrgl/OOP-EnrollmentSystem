package org.example.Interfaces;

import org.example.Entities.Instructor;
import org.example.Entities.Section;
import org.example.Exceptions.DuplicateIDExcep;
import java.util.ArrayList;

public interface IInstructorService {
    void addInstructor(Instructor instructor) throws DuplicateIDExcep;
    void updateInstructor(String instructorID) throws DuplicateIDExcep;
    String removeInstructor(String instructorID);
    void getInstructorDetails(String instructorID);
    void assignInstructorToSection(Instructor instructor, Section section);
    void displayAll();
    ArrayList<Instructor> getAllInstructors();
}