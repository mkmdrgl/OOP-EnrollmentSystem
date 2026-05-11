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

    private static void initializeUniversity() {
        Department ite = new Department("COLLEGE OF INFORMATION TECHNOLOGY AND ENGINEERING");
        ite.getSections().add(new Section("IT2A", 30));
        ite.getSections().add(new Section("IT2B", 30));
        ite.getSections().add(new Section("IT2C", 30));
        ite.getSections().add(new Section("IT2D", 30));
        universityDepartments.add(ite);

        Department ceas = new Department("COLLEGE OF EDUCATION, ARTS, AND SCIENCES");
        ceas.getSections().add(new Section("W1A", 30));
        ceas.getSections().add(new Section("W1B", 30));
        universityDepartments.add(ceas);

        Department cbeam = new Department("COLLEGE OF BUSINESS, ECONOMICS, ACCOUNTACY, AND MANAGEMENT");
        cbeam.getSections().add(new Section("L3A", 30));
        cbeam.getSections().add(new Section("L3B", 30));
        universityDepartments.add(cbeam);

        Department con = new Department("COLLEGE OF NURSING");
        con.getSections().add(new Section("G4A", 30));
        con.getSections().add(new Section("G4B", 30));
        universityDepartments.add(con);
    }

    private static void studentMenu() {
        boolean back = false;
        while (!back) {
            printHeader("STUDENT MANAGEMENT");
            System.out.println(" [1] Register Student     [3] Remove Student");
            System.out.println(" [2] Update Information   [4] List All Students");
            System.out.println(" [0] Back");
            System.out.print("\nSelection > ");
            int choice = getIntInput();
            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("ID: "); String id = scanner.nextLine();
                        System.out.print("Name: "); String name = scanner.nextLine();
                        System.out.print("Program: "); String prog = scanner.nextLine();
                        studentService.addStudent(new Student(id, name, prog));
                    }
                    case 2 -> {
                        System.out.print("Enter ID to Update: ");
                        studentService.updateStudent(scanner.nextLine());
                    }
                    case 3 -> {
                        System.out.print("Enter ID to Delete: ");
                        System.out.println(studentService.removeStudent(scanner.nextLine()));
                    }
                    case 4 -> studentService.displayAll();
                    case 0 -> back = true;
                }
            } catch (DuplicateIDExcep e) { System.err.println(e.getMessage()); }
        }
    }

    private static void instructorMenu() {
        boolean back = false;
        while (!back) {
            printHeader("INSTRUCTOR MANAGEMENT");
            System.out.println(" [1] Add Instructor       [4] Display All");
            System.out.println(" [2] Update Name          [5] View Specific Details");
            System.out.println(" [3] Remove Instructor    [6] Assign to Section");
            System.out.println(" [0] Back");
            System.out.print("\nSelection > ");
            int choice = getIntInput();
            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("ID: "); String id = scanner.nextLine();
                        System.out.print("Name: "); String name = scanner.nextLine();
                        instructorService.addInstructor(new Instructor(id, name));
                    }
                    case 2 -> {
                        System.out.print("ID to Update: ");
                        instructorService.updateInstructor(scanner.nextLine());
                    }
                    case 3 -> {
                        System.out.print("ID to Delete: ");
                        System.out.println(instructorService.removeInstructor(scanner.nextLine()));
                    }
                    case 4 -> instructorService.displayAll();
                    case 5 -> {
                        System.out.print("ID to Find: ");
                        instructorService.getInstructorDetails(scanner.nextLine());
                    }
                    case 6 -> assignInstructorToSectionWorkflow();
                    case 0 -> back = true;
                }
            } catch (DuplicateIDExcep e) { System.err.println(e.getMessage()); }
        }
    }

    private static void courseMenu() {
        boolean back = false;
        while (!back) {
            printHeader("COURSE MANAGEMENT");
            System.out.println(" [1] Add Course      [2] Update Course");
            System.out.println(" [3] Remove Course   [4] Display All");
            System.out.println(" [0] Back");
            System.out.print("\nSelection > ");
            int choice = getIntInput();
            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Code: "); String id = scanner.nextLine();
                        System.out.print("Title: "); String name = scanner.nextLine();
                        System.out.print("Program: "); String prog = scanner.nextLine();
                        courseService.addCourse(new Course(id, name, prog));
                    }
                    case 2 -> {
                        System.out.print("ID to Update: ");
                        courseService.updateCourse(scanner.nextLine());
                    }
                    case 3 -> {
                        System.out.print("ID to Delete: ");
                        System.out.println(courseService.removeCourse(scanner.nextLine()));
                    }
                    case 4 -> courseService.displayAll();
                    case 0 -> back = true;
                }
            } catch (InvalidInputExcep e) { System.err.println(e.getMessage()); }
        }
    }

    private static void tuitionMenu() {
        printHeader("TUITION FEE MANAGEMENT");
        System.out.print("Enter Number of Units: ");
        int units = getIntInput();
        System.out.print("Enter Discount (0.0 to 1.0): ");
        double disc = scanner.nextDouble(); scanner.nextLine();

        double total = tuitionService.calculateFee(units, disc);
        System.out.printf("Total Assessment: PHP %.2f\n", total);

        System.out.print("Enter Payment Amount: ");
        double pay = scanner.nextDouble(); scanner.nextLine();

        try {
            double bal = tuitionService.makePayment(total, pay);
            System.out.printf("--- PAYMENT PROCESSED ---\nRemaining Balance: PHP %.2f\n", bal);
        } catch (InvalidPaymentExcep e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

