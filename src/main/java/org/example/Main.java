package org.example;
import org.example.model.Person;
import org.example.model.Student;
import org.example.model.Instructor;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student(2024390901, "Mikaela Alexa A. Madrigal");
        Instructor instructor1 = new Instructor (2024109093, "Erika Trixie P. Dirilo");

        System.out.println(student1.getID());
        System.out.println(instructor1.getID());
        System.out.println(student1.getName());
        System.out.println(instructor1.getName());


    }
}