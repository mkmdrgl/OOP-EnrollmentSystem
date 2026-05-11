package org.example.Implementations;

import org.example.Entities.Course;
import org.example.Exceptions.InvalidInputExcep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseServiceImplTest {
    private CourseServiceImpl courseService;

    @BeforeEach
    void setUp() {
        courseService = new CourseServiceImpl();
    }

    @Test
    void shouldThrowExceptionWhenAddingEmptyID() {
        Course badCourse = new Course("", "Java", "CS");
        assertThrows(InvalidInputExcep.class, () -> {
            courseService.addCourse(badCourse);
        });
    }

    @Test
    void shouldAddCourseSuccessfully() throws InvalidInputExcep {
        Course validCourse = new Course("CS101", "Java", "CS");
        courseService.addCourse(validCourse);

        assertEquals(1, courseService.getAllCourses().size());
    }

    @Test
    void shouldReturnErrorOnRemovingNonExistentCourse() {
        String result = courseService.removeCourse("999");
        assertEquals("Error: Course not found", result);
    }

    @Test
    void shouldHandleDisplayAllWhenListIsEmpty() {
        assertDoesNotThrow(() -> courseService.displayAll());
    }

    @Test
    void shouldThrowExceptionWhenUpdatingWithBlankName() throws InvalidInputExcep {
        courseService.addCourse(new Course("C101", "Java", "CS"));
        String simulatedInput = "   \nSomeProgram\n";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        assertThrows(InvalidInputExcep.class, () -> {
            courseService.updateCourse("C101");
        });
    }
}