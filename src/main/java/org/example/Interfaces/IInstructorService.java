package org.example.Interfaces;

import org.example.Entities.Instructor;

public interface IInstructorService {
    void addInstructor(Instructor instructor);
    void getInstructorDetails(String instructorID);
    void assignInstructorToSection(String instructorID);
    void displayAll();
}