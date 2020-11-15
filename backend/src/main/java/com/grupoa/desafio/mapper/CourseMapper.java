package com.grupoa.desafio.mapper;

import com.grupoa.desafio.model.Course;
import com.grupoa.desafio.model.Institution;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface CourseMapper {
    Collection<Course> getAllCoursesOfInstitution(@Param("institution") Institution institution);
}
