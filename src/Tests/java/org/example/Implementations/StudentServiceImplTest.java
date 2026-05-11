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
    void shouldAddStudentSuccessfully() throws DuplicateIDExcep {
        Student s1 = new Student("S101", "Alice", "Engineering");
        studentService.addStudent(s1);
        assertEquals(1, studentService.getAllStudents().size());
    }

    @Test
    void shouldThrowExceptionWhenAddingDuplicateID() throws DuplicateIDExcep {
        Student s1 = new Student("S101", "Alice", "Engineering");
        Student s2 = new Student("S101", "Bob", "Arts");

        studentService.addStudent(s1);

        assertThrows(DuplicateIDExcep.class, () -> {
            studentService.addStudent(s2);
        });
    }

    @Test
    void shouldUpdateStudentSuccessfully() throws DuplicateIDExcep {
        Student s1 = new Student("S101", "Alice", "Engineering");
        studentService.addStudent(s1);

        assertDoesNotThrow(() -> studentService.updateStudent("S101"));
    }

    @Test
    void shouldThrowExceptionWhenUpdateFailsToFindID() {
        assertThrows(DuplicateIDExcep.class, () -> {
            studentService.updateStudent("NON_EXISTENT_ID");
        });
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
    void shouldReturnErrorWhenRemovingNonExistentStudent() {
        String result = studentService.removeStudent("999");
        assertEquals("Error: Student not found", result);
    }

    @Test
    void shouldNotCrashWhenDisplayingEmptyList() {
        assertDoesNotThrow(() -> studentService.displayAll());
    }

    @Test
    void shouldDisplayAllStudents() throws DuplicateIDExcep {
        studentService.addStudent(new Student("S1", "Alice", "CS"));
        assertDoesNotThrow(() -> studentService.displayAll());
    }

    @Test
    void shouldHandleRemoveOnEmptyList() {
        String result = studentService.removeStudent("S999");
        assertEquals("Error: Student not found", result);
    }

    @Test
    void shouldHandleUpdateOnEmptyList() {
        assertThrows(DuplicateIDExcep.class, () -> {
            studentService.updateStudent("S999");
        });
    }
}