package org.example;

import org.example.Entities.*;
import org.example.Exceptions.*;
import org.example.Implementations.*;
import org.example.Interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    // Shared Data (In-memory storage)
    private static List<Section> sectionList = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize Services
        IStudentService studentService = new StudentServiceImpl();
        IInstructorService instructorService = new InstructorServiceImpl();
        ICourseService courseService = new CourseServiceImpl();
        IEnrollmentService enrollmentService = new EnrollmentServiceImpl();
        ITuitionService tuitionService = new TuitionServiceImpl();

        boolean running = true;
        while (running) {
            System.out.println("\n========= UNIVERSITY SYSTEM: ALL FEATURES =========");
            System.out.println("1. Student Management (CRUD)");
            System.out.println("2. Instructor Management (CRUD & Assignment)");
            System.out.println("3. Course Management (CRUD)");
            System.out.println("4. Section Management (Create Sections)");
            System.out.println("5. Enrollment (Enroll Student to Section)");
            System.out.println("6. Tuition & Payments");
            System.out.println("7. View Department Hierarchy");
            System.out.println("0. Exit");
            System.out.print("Select Menu: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1": studentMenu(studentService); break;
                case "2": instructorMenu(instructorService); break;
                case "3": courseMenu(courseService); break;
                case "4": sectionMenu(); break;
                case "5": enrollmentMenu(studentService, enrollmentService); break;
                case "6": tuitionMenu(tuitionService); break;
                case "7": enrollmentService.viewDepartmentHierarchy(); break;
                case "0": running = false; break;
                default: System.out.println("Invalid input.");
            }
        }
    }

    // --- 1. STUDENT FEATURES ---
    private static void studentMenu(IStudentService service) {
        System.out.println("\n[Student Management]");
        System.out.println("1. Add Student | 2. Update | 3. Remove | 4. View All");
        String opt = scanner.nextLine();
        try {
            if (opt.equals("1")) {
                System.out.print("ID: "); String id = scanner.nextLine();
                System.out.print("Name: "); String name = scanner.nextLine();
                System.out.print("Program: "); String prog = scanner.nextLine();
                service.addStudent(new Student(id, name, prog));
            } else if (opt.equals("2")) {
                System.out.print("Enter ID to update: ");
                service.updateStudent(scanner.nextLine());
            } else if (opt.equals("3")) {
                System.out.print("Enter ID to remove: ");
                System.out.println(service.removeStudent(scanner.nextLine()));
            } else if (opt.equals("4")) {
                service.displayAll();
            }
        } catch (DuplicateIDExcep e) { System.out.println(e.getMessage()); }
    }

    // --- 2. INSTRUCTOR FEATURES ---
    private static void instructorMenu(IInstructorService service) {
        System.out.println("\n[Instructor Management]");
        System.out.println("1. Add Instructor | 2. Assign to Section | 3. View All");
        String opt = scanner.nextLine();
        if (opt.equals("1")) {
            try {
                System.out.print("ID: "); String id = scanner.nextLine();
                System.out.print("Name: "); String name = scanner.nextLine();
                service.addInstructor(new Instructor(id, name));
            } catch (DuplicateIDExcep e) { System.out.println(e.getMessage()); }
        } else if (opt.equals("2")) {
            // Find Instructor Object
            System.out.print("Enter Instructor ID: ");
            String iid = scanner.nextLine();
            Instructor targetInst = null;
            for(Instructor i : ((InstructorServiceImpl)service).getAllInstructors()) {
                if(i.getID().equals(iid)) { targetInst = i; break; }
            }

            // Find Section Object
            System.out.print("Enter Section Name: ");
            String sname = scanner.nextLine();
            Section targetSec = null;
            for(Section s : sectionList) {
                if(s.getSectionName().equalsIgnoreCase(sname)) { targetSec = s; break; }
            }

            service.assignInstructorToSection(targetInst, targetSec);
        } else if (opt.equals("3")) {
            service.displayAll();
        }
    }

    // --- 3. COURSE FEATURES ---
    private static void courseMenu(ICourseService service) {
        System.out.println("\n[Course Management]");
        System.out.println("1. Add Course | 2. View All");
        String opt = scanner.nextLine();
        if (opt.equals("1")) {
            try {
                System.out.print("Course ID: "); String id = scanner.nextLine();
                System.out.print("Course Name: "); String name = scanner.nextLine();
                System.out.print("Program: "); String prog = scanner.nextLine();
                service.addCourse(new Course(id, name, prog));
            } catch (InvalidInputExcep e) { System.out.println(e.getMessage()); }
        } else if (opt.equals("2")) {
            service.displayAll();
        }
    }

    // --- 4. SECTION FEATURES ---
    private static void sectionMenu() {
        System.out.println("\n[Section Management]");
        System.out.print("Enter Section Name (e.g. BSIT-1A): ");
        String name = scanner.nextLine();
        System.out.print("Enter Max Capacity: ");
        int cap = Integer.parseInt(scanner.nextLine());
        sectionList.add(new Section(name, cap));
        System.out.println("Section created.");
    }

    // --- 5. ENROLLMENT FEATURES ---
    private static void enrollmentMenu(IStudentService sService, IEnrollmentService eService) {
        System.out.println("\n[Enrollment]");
        System.out.print("Enter Student ID: ");
        String sid = scanner.nextLine();
        // This is a simplified lookup logic
        Student targetStudent = null;
        // In a real app, StudentService should have a getByID method.

        System.out.print("Enter Section Name: ");
        String sname = scanner.nextLine();
        Section targetSection = null;
        for(Section s : sectionList) {
            if(s.getSectionName().equalsIgnoreCase(sname)) { targetSection = s; break; }
        }

        try {
            eService.enrollStudent(targetStudent, targetSection);
        } catch (SectionFullExcep e) { System.out.println(e.getMessage()); }
    }

    // --- 6. TUITION FEATURES ---
    private static void tuitionMenu(ITuitionService service) {
        System.out.println("\n[Tuition & Payment]");
        System.out.print("Enter number of units: ");
        int units = Integer.parseInt(scanner.nextLine());
        double fee = service.calculateFee(units, 0.10); // 10% discount default
        System.out.println("Total Tuition: " + fee);

        System.out.print("Enter payment amount: ");
        double pay = Double.parseDouble(scanner.nextLine());
        try {
            double balance = service.makePayment(fee, pay);
            System.out.println("Payment Successful. Remaining Balance: " + balance);
        } catch (InvalidPaymentExcep e) { System.out.println(e.getMessage()); }
    }
}