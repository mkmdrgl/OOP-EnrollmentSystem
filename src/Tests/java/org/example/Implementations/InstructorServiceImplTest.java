package org.example.Implementations;

import org.example.Entities.Instructor;
import org.example.Exceptions.DuplicateIDExcep;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

class InstructorServiceImplTest {
    private InstructorServiceImpl instructorService;
    private final InputStream systemInBackup = System.in;

    @BeforeEach
    void setUp() {
        instructorService = new InstructorServiceImpl();
    }

    @AfterEach
    void tearDown() {
        System.setIn(systemInBackup);
    }

    private void simulateUserInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    void shouldAddInstructorSuccessfully() throws DuplicateIDExcep {
        Instructor ins = new Instructor("INS01", "Dr. Smith");
        instructorService.addInstructor(ins);

        assertEquals(1, instructorService.getAllInstructors().size());
    }

    @Test
    void shouldThrowExceptionWhenAddingDuplicate() throws DuplicateIDExcep {
        instructorService.addInstructor(new Instructor("INS01", "Dr. Smith"));

        assertThrows(DuplicateIDExcep.class, () -> {
            instructorService.addInstructor(new Instructor("INS01", "Prof. Jones"));
        });
    }

    @Test
    void shouldPrintDetailsWhenInstructorFound() throws DuplicateIDExcep {
        instructorService.addInstructor(new Instructor("INS01", "Dr. Smith"));

        assertDoesNotThrow(() -> instructorService.getInstructorDetails("INS01"));
    }

    @Test
    void shouldPrintNotFoundWhenInstructorMissing() {
        assertDoesNotThrow(() -> instructorService.getInstructorDetails("999"));
    }

    @Test
    void shouldAssignCourseWhenInstructorExists() throws DuplicateIDExcep {
        instructorService.addInstructor(new Instructor("INS01", "Dr. Smith"));
        assertDoesNotThrow(() -> instructorService.assignInstructorToSection("INS01"));
    }

    @Test
    void shouldNotAssignWhenInstructorNotFound() {
        assertDoesNotThrow(() -> instructorService.assignInstructorToSection("INVALID_ID"));
    }

    @Test
    void shouldExecuteDisplayAll() throws DuplicateIDExcep {
        instructorService.addInstructor(new Instructor("INS01", "Dr. Smith"));
        assertDoesNotThrow(() -> instructorService.displayAll());
    }
}