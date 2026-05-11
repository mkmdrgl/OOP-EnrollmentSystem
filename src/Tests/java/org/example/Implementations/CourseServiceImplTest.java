package org.example.Implementations;

import org.example.Entities.Course;
import org.example.Exceptions.InvalidInputExcep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceImplTest {

    private CourseServiceImpl courseService;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        courseService = new CourseServiceImpl();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void addCourse_Success() throws InvalidInputExcep {
        Course course = new Course("CS101", "Computer Science", "BSCS");
        courseService.addCourse(course);

        assertEquals(1, courseService.getAllCourses().size());
        assertTrue(outputStreamCaptor.toString().contains("added successfully"));
    }

    @Test
    void addCourse_EmptyID_ThrowsException() {
        Course course = new Course("", "Invalid Course", "BSIT");

        assertThrows(InvalidInputExcep.class, () -> courseService.addCourse(course));
    }

    @Test
    void addCourse_DuplicateID_ThrowsException() throws InvalidInputExcep {
        courseService.addCourse(new Course("MATH1", "Math 1", "BSCE"));
        Course duplicate = new Course("math1", "Math 2", "BSCE");

        assertThrows(InvalidInputExcep.class, () -> courseService.addCourse(duplicate));
    }

    @Test
    void updateCourse_Success() throws InvalidInputExcep {
        courseService.addCourse(new Course("ENG1", "English", "AB-ENG"));

        String simulatedInput = "Advanced English\nLiberal Arts\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        courseService = new CourseServiceImpl();
        courseService.addCourse(new Course("ENG1", "English", "AB-ENG"));

        courseService.updateCourse("ENG1");

        Course updated = courseService.getAllCourses().get(0);
        assertEquals("Advanced English", updated.getCourseName());
        assertEquals("Liberal Arts", updated.getProgram());
        System.setIn(originalIn);
    }

    @Test
    void updateCourse_NotFound() {
        courseService.updateCourse("999");
        assertTrue(outputStreamCaptor.toString().contains("Course not found."));
    }

    @Test
    void removeCourse_Success() throws InvalidInputExcep {
        courseService.addCourse(new Course("HIST1", "History", "AB-HIST"));

        String result = courseService.removeCourse("HIST1");

        assertEquals("Course HIST1 successfully deleted.", result);
        assertEquals(0, courseService.getAllCourses().size());
    }

    @Test
    void removeCourse_NotFound() {
        String result = courseService.removeCourse("VOID");
        assertEquals("Error: Course not found.", result);
    }

    @Test
    void displayAll_EmptyList() {
        courseService.displayAll();
        assertEquals("No courses registered in the system.", outputStreamCaptor.toString().trim());
    }

    @Test
    void displayAll_WithData() throws InvalidInputExcep {
        courseService.addCourse(new Course("CS1", "CS", "BSCS"));
        outputStreamCaptor.reset();

        courseService.displayAll();

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("--- Registered Courses ---"));
        assertTrue(output.contains("CS1"));
    }

    @Test
    void getAllCourses_ReturnsCorrectReference() throws InvalidInputExcep {
        ArrayList<Course> list = courseService.getAllCourses();
        assertNotNull(list);

        courseService.addCourse(new Course("T1", "Test", "Test"));
        assertEquals(1, list.size());
    }
}