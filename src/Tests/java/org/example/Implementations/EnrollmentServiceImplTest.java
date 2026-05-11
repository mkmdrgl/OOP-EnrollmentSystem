package org.example.Implementations;

import org.example.Entities.Section;
import org.example.Entities.Student;
import org.example.Exceptions.SectionFullExcep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class EnrollmentServiceImplTest {
    private EnrollmentServiceImpl enrollmentService;

    @BeforeEach
    void setUp() {
        enrollmentService = new EnrollmentServiceImpl();
    }

    @Test
    void shouldEnrollStudentSuccessfully() throws SectionFullExcep {
        Section section = new Section("Java 101", 30);
        Student student = new Student();
        student.setName("Alice");

        enrollmentService.enrollStudent(student, section);

        assertEquals(1, section.getEnrolledStudents().size());
        assertEquals("Alice", section.getEnrolledStudents().get(0).getName());
    }

    @Test
    void shouldThrowSectionFullExcepWhenCapacityIsReached() {
        Section section = new Section("Data Science", 1);
        Student firstStudent = new Student();
        Student secondStudent = new Student();

        try {
            enrollmentService.enrollStudent(firstStudent, section);
        } catch (SectionFullExcep e) {
            fail("Should not have thrown exception for the first student");
        }

        SectionFullExcep exception = assertThrows(SectionFullExcep.class, () -> {
            enrollmentService.enrollStudent(secondStudent, section);
        });

        assertTrue(exception.getMessage().contains("is full"));
    }

    @Test
    void shouldNotCrashWhenViewingEmptyHierarchy() {
        assertDoesNotThrow(() -> enrollmentService.viewDepartmentHierarchy());
    }
}