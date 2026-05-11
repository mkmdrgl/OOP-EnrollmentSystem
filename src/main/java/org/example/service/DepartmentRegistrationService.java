package org.example.service;

import org.example.Entities.Department;
import org.example.Entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class DepartmentRegistrationService {
    List<Department> departments;
    List<Instructor> instructorList;
}

public DepartmentRegistrationService() {
    this.departments = new ArrayList<>();
    this.instructorList = new ArrayList<>();
}


