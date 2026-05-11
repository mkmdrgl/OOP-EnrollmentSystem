package org.example;

import org.example.Entities.*;
import org.example.Implementations.*;
import org.example.Exceptions.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static final StudentServiceImpl studentService = new StudentServiceImpl();
    private static final InstructorServiceImpl instructorService = new InstructorServiceImpl();
    private static final CourseServiceImpl courseService = new CourseServiceImpl();
    private static final EnrollmentServiceImpl enrollmentService = new EnrollmentServiceImpl();
    private static final TuitionServiceImpl tuitionService = new TuitionServiceImpl();

    private static final List<Department> universityDepartments = new ArrayList<>();

    public static void main(String[] args) {
        initializeUniversity();

        boolean running = true;
        while (running) {
            printHeader("ENROLLMENT SYSTEM");
            System.out.println(" [1] Student Portal");
            System.out.println(" [2] Instructor Portal");
            System.out.println(" [3] Course Portal");
            System.out.println(" [4] Tuition Fee Payment");
            System.out.println(" [5] Enrollment and College Departments");
            System.out.println(" [0] Exit");
            System.out.print("\nSelection > ");

            int choice = getIntInput();
            switch (choice) {
                case 1 -> studentMenu();
                case 2 -> instructorMenu();
                case 3 -> courseMenu();
                case 4 -> tuitionMenu();
                case 5 -> hierarchyEnrollmentMenu();
                case 0 -> running = false;
                default -> System.out.println("!! Invalid Choice. Try again.");
            }
        }
    }
