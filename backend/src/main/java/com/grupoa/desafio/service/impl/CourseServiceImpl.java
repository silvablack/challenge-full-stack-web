package com.grupoa.desafio.service.impl;

import com.grupoa.desafio.mapper.CourseMapper;
import com.grupoa.desafio.model.Course;
import com.grupoa.desafio.model.Institution;
import com.grupoa.desafio.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseMapper courseMapper;

    @Override
    public Collection<Course> getCoursesOfInstitution (Institution institution) {
        return courseMapper.getAllCoursesOfInstitution(institution);
    }
}
