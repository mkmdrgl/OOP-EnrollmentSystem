package org.example;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        student.setstudentID("000123");
        student.setstudentName("John Doe");
        student.setprogram("BS Information Technology");

        System.out.println("Student ID: " + student.getstudentID());
        System.out.println("Student Name: " + student.getstudentName());
        System.out.println("Program: " + student.getprogram());
        System.out.print("\n");

        Student student2 = new Student();
        student2.setstudentID("000124");
        student2.setstudentName("Jane Doe");
        student2.setprogram("BS Information Technology");

        System.out.println("Student ID: " + student2.getstudentID());
        System.out.println("Student Name: " + student2.getstudentName());
        System.out.println("Program: " + student2.getprogram());
        System.out.print("\n");

        Course course = new Course();
        course.setcourseID("000001");
        course.setcourseName("Integrative Programming");
        course.setprogram("BS Information Technology");

        System.out.println("Course ID: " + course.getcourseID());
        System.out.println("Course Name: " + course.getcourseName());
        System.out.println("Course: " + course.getprogram());
        System.out.print("\n");

    }
}