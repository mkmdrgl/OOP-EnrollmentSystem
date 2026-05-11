package org.example.service;
import org.example.model.Course;
import java.util.Scanner;
import java.util.ArrayList;

public class CourseEnrollment {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Course> coursesList = new ArrayList<>();

    public void addCourse (Course course) {
        coursesList.add(course);
    }

    public void displayAll() {
        System.out.println(coursesList);
    }

    public void updateCourse (Course course) {
        for(int i = 0; i < coursesList.size(); i++) {
            if(coursesList.get(i).getcourseID().equals(course.getcourseID())) {
                System.out.print("Enter new course: ");
                String name = input.nextLine();

                System.out.print("Enter new program: ");
                String program = input.nextLine();

                coursesList.set(i, new Course(course.getcourseID(), name, program));
            }
        }
    }

    public String deleteCourse(Course course) {
        for(int i = 0; i < coursesList.size(); i++) {
            if(coursesList.get(i).getcourseID().equals(course.getcourseID())) {
                coursesList.remove(i);
                return "Successfully deleted the course.";
            }
        }
        return "Error occurred with deleting the course";
    }

}
