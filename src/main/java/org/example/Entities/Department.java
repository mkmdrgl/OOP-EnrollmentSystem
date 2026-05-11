package org.example.Entities;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Section> sections;

    public Department() {
        this("Unknown");
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.sections = new ArrayList<>();
    }

    public String getDepartment() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return String.format("Department [Name: %s, Total Sections: %d]",
                getDepartment(),
                (getSections() != null ? getSections().size() : 0));
    }

}