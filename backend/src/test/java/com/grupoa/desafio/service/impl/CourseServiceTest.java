package com.grupoa.desafio.service.impl;


import com.grupoa.desafio.mapper.CourseMapper;
import com.grupoa.desafio.model.Course;
import com.grupoa.desafio.model.Institution;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.Collections;

public class CourseServiceTest {
    private CourseMapper courseMapper;
    private CourseServiceImpl courseService;

    @Before
    public void setup() {
        courseMapper = Mockito.mock(CourseMapper.class);
        courseService = new CourseServiceImpl(courseMapper);
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

    @Test
    public void shouldReturnCollectionOfInstitution () {
        // scene
        Institution institution = createInstitution();
        Collection<Course> expectedCouses  = Collections.singletonList(createCourse(institution));
        Mockito.when(courseMapper.getAllCoursesOfInstitution(institution)).thenReturn(expectedCouses);

        // execution
        Collection<Course> courses = courseService.getCoursesOfInstitution(institution);

        // test
        Assertions.assertEquals(expectedCouses, courses);
    }
}
