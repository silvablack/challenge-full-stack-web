package com.grupoa.desafio.mapper;

import com.grupoa.desafio.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface StudentMapper {
    Collection<Student> getAll();
    Student getByRegistration(@Param("registrationId") Long registrationId);
    Student getByCPF(@Param("cpf") String cpf);
    void create(@Param("student") Student student);
    void update(@Param("student") Student student);
    void destroy(@Param("registrationId") Long registrationId);
    void softDelete(@Param("registrationId") Long registrationId);
}
