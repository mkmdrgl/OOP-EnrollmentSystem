package org.example.Implementations;

import org.example.Entities.*;
import org.example.Exceptions.SectionFullExcep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class EnrollmentServiceImplTest {

    private EnrollmentServiceImpl enrollmentService;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        enrollmentService = new EnrollmentServiceImpl();
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setErr(new PrintStream(errStreamCaptor));
    }

    @Test
    void enrollStudentInSection_Success() throws SectionFullExcep {
        Section section = new Section("BSIT-1A", 1);
        Student student = new Student("S1", "John Doe", "BSIT");

        enrollmentService.enrollStudentInSection(student, section);

        assertEquals(1, section.getEnrolledStudents().size());
        assertEquals(student, section.getEnrolledStudents().get(0));
        assertTrue(outputStreamCaptor.toString().contains("Success: Enrolled John Doe"));
    }

    @Test
    void enrollStudentInSection_ThrowsExceptionWhenFull() throws SectionFullExcep {
        Section section = new Section("BSIT-1A", 1);
        Student student1 = new Student("S1", "John Doe", "BSIT");
        Student student2 = new Student("S2", "Jane Smith", "BSIT");

        enrollmentService.enrollStudentInSection(student1, section);

        SectionFullExcep exception = assertThrows(SectionFullExcep.class, () -> {
            enrollmentService.enrollStudentInSection(student2, section);
        });

        assertEquals(1, section.getEnrolledStudents().size());
        assertTrue(exception.getMessage().contains("is full"));
        assertTrue(errStreamCaptor.toString().contains("ERROR:"));
    }

    @Test
    void viewDepartmentHierarchy_NoCrash() {
        assertDoesNotThrow(() -> enrollmentService.viewDepartmentHierarchy());
    }

    @Test
    void displayDepartmentHierarchy_NullDepartment() {
        enrollmentService.displayDepartmentHierarchy(null);
        assertEquals("Error: Department is null.", outputStreamCaptor.toString().trim());
    }

    @Test
    void displayDepartmentHierarchy_FullDisplayLogic() throws SectionFullExcep {
        Department dept = new Department("College of Tech");
        Section section = new Section("BSIT-1A", 30);
        Instructor instructor = new Instructor("I1", "Prof. X");
        Student student = new Student("S1", "Alice", "BSIT");

        section.setAssignedInstructor(instructor);
        dept.getSections().add(section);
        enrollmentService.enrollStudentInSection(student, section);

        outputStreamCaptor.reset();

        enrollmentService.displayDepartmentHierarchy(dept);

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("DEPARTMENT: College of Tech"));
        assertTrue(output.contains("SECTION: BSIT-1A"));
        assertTrue(output.contains("Instructor: Prof. X"));
        assertTrue(output.contains("- Alice"));
        assertTrue(output.contains("[1/30]"));
    }

    @Test
    void displayDepartmentHierarchy_NoInstructorNoStudents() {
        Department dept = new Department("Empty Dept");
        Section section = new Section("VOID-101", 10);
        dept.getSections().add(section);

        enrollmentService.displayDepartmentHierarchy(dept);

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Instructor: TBA"));
        assertTrue(output.contains("- No students enrolled."));
    }
}