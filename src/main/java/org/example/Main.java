package org.example;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        student.setstudentID(2024390901);
        student.setstudentName("Mikaela Alexa A. Madrigal");
        student.setprogram("BS Information Technology");

        System.out.println("Student ID: " + student.getstudentID());
        System.out.println("Student Name: " + student.getstudentName());
        System.out.println("Program: " + student.getprogram());
        System.out.println("\n");

        Student student2 = new Student();
        student2.setstudentID(2024108057);
        student2.setstudentName("Faye Jeremiah L. Diaz");
        student2.setprogram("BS Psychology");

        System.out.println("Student ID: " + student2.getstudentID());
        System.out.println("Student Name: " + student2.getstudentName());
        System.out.println("Program: " + student2.getprogram());
        System.out.println("\n");

        Course course = new Course();
        course.setcourseID("ABCD9876");
        course.setcourseName("Inteprog");
        course.setcourse("Integrative Programming");

        System.out.println("Course ID: " + course.getcourseID());
        System.out.println("Course Name: " + course.getcourseName());
        System.out.println("Course: " + course.getcourse());
        System.out.println("\n");

        Course course2 = new Course();
        course2.setcourseID("EFGH5432");
        course2.setcourseName("Linusyst");
        course2.setcourse("Linux Systems");
        System.out.println("\n");

        System.out.println("Course ID: " + course2.getcourseID());
        System.out.println("Course Name: " + course2.getcourseName());
        System.out.println("Course: " + course2.getcourse());

    }
}