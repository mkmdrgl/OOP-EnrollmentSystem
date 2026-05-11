package org.example.Implementations;

import org.example.Entities.Student;
import org.example.Exceptions.DuplicateIDExcep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    private StudentServiceImpl studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentServiceImpl();
    }

    @Test
    void shouldThrowExceptionWhenAddingDuplicateID() throws DuplicateIDExcep {
        Student s1 = new Student("S101", "Alice", "Engineering");
        Student s2 = new Student("S101", "Bob", "Arts"); // Same ID

        studentService.addStudent(s1);

        assertThrows(DuplicateIDExcep.class, () -> {
            studentService.addStudent(s2);
        }, "Adding the same ID twice should trigger DuplicateIDExcep");
    }

    @Test
    void shouldSuccessfullyRemoveStudent() throws DuplicateIDExcep {
        Student charlie = new Student("S555", "Charlie", "Science");
        studentService.addStudent(charlie);

        String result = studentService.removeStudent("S555");

        assertEquals("Student S555 has been removed.", result);
        assertEquals(0, studentService.getAllStudents().size());
    }

    @Test
    void shouldThrowExceptionWhenUpdateFailsToFindID() {
        assertThrows(DuplicateIDExcep.class, () -> {
            studentService.updateStudent("NON_EXISTENT_ID");
        });
    }
}