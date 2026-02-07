package org.example;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        student.setstudentID("000123");
        student.setstudentName("John Doe");
        student.setprogram("BS Information Technology");
        student.display();
        System.out.print("\n");

        Student student2 = new Student();
        student2.setstudentID("000124");
        student2.setstudentName("Jane Doe");
        student2.setprogram("BS Information Technology");
        student2.display();
        System.out.print("\n");

        Course course = new Course();
        course.setcourseID("000001");
        course.setcourseName("Integrative Programming");
        course.setprogram("BS Information Technology");
        course.display();

    }
}