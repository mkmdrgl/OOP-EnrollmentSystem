package org.example.Interfaces;

import org.example.Entities.Course;
import java.util.ArrayList;

public interface ICourseService {
    void addCourse(Course course);
    void updateCourse(String courseID);
    String removeCourse(String courseID);
    void displayAll();
    ArrayList<Course> getAllCourses();
}