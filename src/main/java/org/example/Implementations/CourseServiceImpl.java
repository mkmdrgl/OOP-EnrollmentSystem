package org.example.Implementations;

import org.example.Entities.Course;
import org.example.Interfaces.ICourseService;
import org.example.Exceptions.InvalidInputExcep;
import java.util.Scanner;
import java.util.ArrayList;

public class CourseServiceImpl implements ICourseService {
    Scanner input = new Scanner(System.in);
    private ArrayList<Course> courseList = new ArrayList<>();

    public void addCourse(Course course) throws InvalidInputExcep {
        if (course.getcourseID() == null || course.getcourseID().trim().isEmpty()) {
            throw new InvalidInputExcep("Error: Course ID cannot be empty.");
        }
        if (course.getcourseName() == null || course.getcourseName().trim().isEmpty()) {
            throw new InvalidInputExcep("Error: Course Name cannot be empty.");
        }
        courseList.add(course);
        System.out.println("Course added successfully.");
    }

    public void updateCourse(String courseID) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getcourseID().equals(courseID)) {

                System.out.print("Enter new course name: ");
                String name = input.nextLine();

                System.out.print("Enter new program: ");
                String program = input.nextLine();

                courseList.get(i).setcourseName(name);
                courseList.get(i).setprogram(program);

                System.out.println("Course updated successfully.");
                return;
            }
        }
        System.out.println("Course not found.");
    }

    public String removeCourse(String courseID) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getcourseID().equals(courseID)) {
                courseList.remove(i);
                return "Successfully Deleted";
            }
        }
        return "Error: Course not found";
    }

    public void displayAll() {
        System.out.println(courseList);
    }

    public ArrayList<Course> getAllCourses() {
        return courseList;
    }
}