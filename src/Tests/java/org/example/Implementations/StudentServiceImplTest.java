package org.example.Implementations;

import org.example.Entities.Student;
import org.example.Exceptions.DuplicateIDExcep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

    private StudentServiceImpl studentService;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        studentService = new StudentServiceImpl();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testAddStudentLogic() throws DuplicateIDExcep {
        Student s1 = new Student("S101", "Alice", "BSIT");
        studentService.addStudent(s1);

        assertEquals(1, studentService.getAllStudents().size());

        assertThrows(DuplicateIDExcep.class, () -> {
            studentService.addStudent(new Student("S101", "Bob", "BSCS"));
        });
    }

    @Test
    void testUpdateStudentSuccess() throws DuplicateIDExcep {
        studentService.addStudent(new Student("S101", "Alice", "BSIT"));

        String simulatedInput = "Alice Smith\nBSCS\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        studentService = new StudentServiceImpl();
        studentService.addStudent(new Student("S101", "Alice", "BSIT"));

        studentService.updateStudent("S101");

        Student updated = studentService.getAllStudents().get(0);
        assertEquals("Alice Smith", updated.getName());
        assertEquals("BSCS", updated.getProgram());
    }

    @Test
    void testUpdateStudentNotFound() {
        assertThrows(DuplicateIDExcep.class, () -> {
            studentService.updateStudent("999");
        });
    }

    @Test
    void testRemoveStudentLogic() throws DuplicateIDExcep {
        studentService.addStudent(new Student("S101", "Alice", "BSIT"));

        String result = studentService.removeStudent("S101");
        assertEquals("Student S101 has been removed.", result);
        assertEquals(0, studentService.getAllStudents().size());

        String errorResult = studentService.removeStudent("S101");
        assertEquals("Error: Student not found", errorResult);
    }

    @Test
    void testDisplayAllLogic() throws DuplicateIDExcep {
        studentService.displayAll();
        assertTrue(outputStreamCaptor.toString().contains("No students registered"));

        outputStreamCaptor.reset();
        studentService.addStudent(new Student("S101", "Alice", "BSIT"));
        studentService.displayAll();
        assertTrue(outputStreamCaptor.toString().contains("Alice"));
    }
}