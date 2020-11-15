package com.grupoa.desafio.controller;

import com.grupoa.desafio.exception.ResourceNotFoundException;
import com.grupoa.desafio.model.Course;
import com.grupoa.desafio.model.Institution;
import com.grupoa.desafio.service.CourseService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @ApiOperation("GET all courses of institution")
    @GetMapping
    public ResponseEntity<Collection<Course>> getAllCoursesOfInstitution (@RequestParam("institution_id") Long institution_id) throws ResourceNotFoundException {
        Institution institution = Institution.builder().id(institution_id).build();
        Optional<Collection<Course>> listCourses = Optional.ofNullable(courseService.getCoursesOfInstitution(institution));
        return listCourses.map(courses -> ResponseEntity.ok().body(courses)
        ).orElseThrow( () -> new ResourceNotFoundException("No courses found of this institution"));
    }
}
