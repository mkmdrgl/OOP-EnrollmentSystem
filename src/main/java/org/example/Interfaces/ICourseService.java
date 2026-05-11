package org.example.Interfaces;

import org.example.Entities.Course;
import java.util.Scanner;
import java.util.ArrayList;

public class ICourseService {
    Scanner input = new Scanner(System.in);
    private ArrayList<Course> courseList = new ArrayList<>();

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public void updateCourse(String courseID) {
        for (int i = 0; i < courseList.size(); i++) {
            // Using your specific method name: getcourseID()
            if (courseList.get(i).getcourseID().equals(courseID)) {

                System.out.print("Enter new course name: ");
                String name = input.nextLine();

                System.out.print("Enter new program: ");
                String program = input.nextLine();

                // Using your specific method names: setcourseName() and setprogram()
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