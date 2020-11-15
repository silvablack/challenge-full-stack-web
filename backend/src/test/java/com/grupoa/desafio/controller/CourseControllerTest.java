package com.grupoa.desafio.controller;

import com.grupoa.desafio.exception.ResourceNotFoundException;
import com.grupoa.desafio.model.Course;
import com.grupoa.desafio.model.Institution;
import com.grupoa.desafio.service.impl.CourseServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Collections;

public class CourseControllerTest {
    private CourseController courseController;
    private CourseServiceImpl courseService;

    @Before
    public void setup() {
        courseService = Mockito.mock(CourseServiceImpl.class);
        courseController = new CourseController(courseService);
    }

    private Institution createInstitution() {
        return Institution.builder()
                .id(1L)
                .description("EdTech")
                .active(true).build();
    }

    private Course createCourse(Institution institution) {
        return Course.builder().id(1L).description("Programacao Web").active(true).institution(institution).build();
    }

//    @Test
//    public void shouldGetAllCoursesOfInstitution() throws ResourceNotFoundException {
//        // scene
//        Institution institution = createInstitution();
//        Course course = createCourse(institution);
//        Collection<Course> expectedCourses = Collections.singletonList(course);
//        Mockito.when(courseService.getCoursesOfInstitution(institution)).thenReturn(expectedCourses);
//
//        // execution
//        ResponseEntity<Collection<Course>> resultResponseGetCourses = courseController.getAllCoursesOfInstitution(institution.getId());
//
//        // test
//        Assertions.assertEquals(HttpStatus.OK, resultResponseGetCourses.getStatusCode());
//        Assertions.assertEquals(expectedCourses, resultResponseGetCourses.getBody());
//    }
}
