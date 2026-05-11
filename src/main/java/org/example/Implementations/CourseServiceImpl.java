package org.example.Implementations;

import org.example.Entities.Course;
import org.example.Interfaces.ICourseService;
import org.example.Exceptions.InvalidInputExcep;
import java.util.Scanner;
import java.util.ArrayList;

public class CourseServiceImpl implements ICourseService {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Course> courseList = new ArrayList<>();

    public void addCourse(Course course) throws InvalidInputExcep {
        if (course.getCourseID() == null || course.getCourseID().trim().isEmpty()) {
            throw new InvalidInputExcep("Error: Course ID cannot be empty.");
        }

        for (Course c : courseList) {
            if (c.getCourseID().equalsIgnoreCase(course.getCourseID())) {
                throw new InvalidInputExcep("Error: Course ID " + course.getCourseID() + " already exists.");
            }
        }

        courseList.add(course);
        System.out.println("Course [" + course.getCourseName() + "] added successfully.");
    }

    public void updateCourse(String courseID) {
        for (Course c : courseList) {
            if (c.getCourseID().equals(courseID)) {
                System.out.print("Enter new course name: ");
                c.setCourseName(input.nextLine());

                System.out.print("Enter new program: ");
                c.setProgram(input.nextLine());

                System.out.println("Course updated successfully.");
                return;
            }
        }
        System.out.println("Course not found.");
    }

    public String removeCourse(String courseID) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseID().equals(courseID)) {
                courseList.remove(i);
                return "Course " + courseID + " successfully deleted.";
            }
        }
        return "Error: Course not found.";
    }

    public void displayAll() {
        if (courseList.isEmpty()) {
            System.out.println("No courses registered in the system.");
        } else {
            System.out.println("--- Registered Courses ---");
            for (Course c : courseList) {
                System.out.println(c);
            }
        }
    }

    public ArrayList<Course> getAllCourses() {
        return courseList;
    }
}