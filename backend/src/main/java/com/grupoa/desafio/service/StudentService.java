package com.grupoa.desafio.service;

import com.grupoa.desafio.exception.OperationNotCompleteException;
import com.grupoa.desafio.exception.StudentAlreadyExistsException;
import com.grupoa.desafio.model.Student;

import java.util.Collection;

public interface StudentService {
    Student getByRegistration(Long registrationId);
    Collection<Student> getAll();
    void create(Student student) throws StudentAlreadyExistsException, OperationNotCompleteException;
    void update(Student student) throws OperationNotCompleteException;
    void delete(Long registrationId) throws OperationNotCompleteException;
}
