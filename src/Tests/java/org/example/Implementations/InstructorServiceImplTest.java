package org.example.Implementations;

import org.example.Entities.Instructor;
import org.example.Entities.Section;
import org.example.Exceptions.DuplicateIDExcep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InstructorServiceImplTest {

    private InstructorServiceImpl instructorService;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        instructorService = new InstructorServiceImpl();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testInstructorLifecycle() throws DuplicateIDExcep {
        Instructor inst = new Instructor("INS-01", "Dr. Smith");

        instructorService.addInstructor(inst);
        assertThrows(DuplicateIDExcep.class, () -> instructorService.addInstructor(new Instructor("INS-01", "Dup")));
        assertEquals(1, instructorService.getAllInstructors().size());

        assertEquals("Instructor INS-01 has been removed.", instructorService.removeInstructor("INS-01"));
        assertEquals("Error: Instructor not found", instructorService.removeInstructor("999"));
        assertEquals(0, instructorService.getAllInstructors().size());
    }

    @Test
    void testSearchAndUpdate() throws DuplicateIDExcep {
        instructorService.addInstructor(new Instructor("I1", "Old Name"));

        System.setIn(new ByteArrayInputStream("New Name\n".getBytes()));
        instructorService = new InstructorServiceImpl();
        instructorService.addInstructor(new Instructor("I1", "Old Name"));
        instructorService.updateInstructor("I1");

        outputStreamCaptor.reset();
        instructorService.getInstructorDetails("I1");

        assertTrue(outputStreamCaptor.toString().contains("New Name"));
        assertThrows(DuplicateIDExcep.class, () -> instructorService.updateInstructor("InvalidID"));
    }

    @Test
    void testAssignmentLogic() {
        Instructor instructor = new Instructor("I1", "Prof. X");
        Section section = new Section("CS101", 30);

        instructorService.assignInstructorToSection(instructor, section);
        assertEquals(instructor, section.getAssignedInstructor());

        instructorService.assignInstructorToSection(null, null);
        assertTrue(outputStreamCaptor.toString().contains("Assignment failed"));
    }

    @Test
    void testDisplayAll() throws DuplicateIDExcep {
        instructorService.displayAll();
        assertTrue(outputStreamCaptor.toString().contains("No instructors registered"));

        outputStreamCaptor.reset();
        instructorService.addInstructor(new Instructor("I1", "Prof. X"));
        instructorService.displayAll();
        assertTrue(outputStreamCaptor.toString().contains("Prof. X"));
    }
}