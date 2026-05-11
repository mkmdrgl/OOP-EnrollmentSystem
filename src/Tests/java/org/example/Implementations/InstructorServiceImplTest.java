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

        assertDoesNotThrow(() -> instructorService.addInstructor(new Instructor("INS02", "Prof. Doe")));
    }
}