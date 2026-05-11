package org.example.Entities;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String sectionName;
    private int maxCapacity;
    private Instructor assignedInstructor;
    private List<Student> enrolledStudents;

    public Section() {
        this("Unknown", 30);
    }

    public Section(String sectionName, int maxCapacity) {
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Instructor getAssignedInstructor() {
        return assignedInstructor;
    }

    public void setAssignedInstructor(Instructor assignedInstructor) {
        this.assignedInstructor = assignedInstructor;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    @Override
    public String toString() {
        return "Section{" +
                "name='" + sectionName + '\'' +
                ", capacity=" + enrolledStudents.size() + "/" + maxCapacity +
                ", instructor=" + (assignedInstructor != null ? assignedInstructor.getName() : "None") +
                '}';
    }
}