package org.example.Interfaces;

import org.example.Entities.Instructor;
import org.example.Exceptions.DuplicateIDExcep;

public interface IInstructorService {
    void addInstructor(Instructor instructor) throws DuplicateIDExcep;
    void updateInstructor(String instructorID) throws DuplicateIDExcep;
    String removeInstructor(String instructorID);
    void getInstructorDetails(String instructorID);
    void assignInstructorToSection(String instructorID);
    void displayAll();
}