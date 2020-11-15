package com.grupoa.desafio.service;

import com.grupoa.desafio.model.Course;
import com.grupoa.desafio.model.Institution;

import java.util.Collection;

public interface CourseService {
    Collection<Course> getCoursesOfInstitution(Institution institution);
}
