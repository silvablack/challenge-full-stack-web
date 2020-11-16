package com.grupoa.desafio.service.impl;

import com.grupoa.desafio.exception.OperationNotCompleteException;
import com.grupoa.desafio.exception.StudentAlreadyExistsException;
import com.grupoa.desafio.mapper.StudentMapper;
import com.grupoa.desafio.model.Student;
import com.grupoa.desafio.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    @Override
    public Student getByRegistration(Long registrationId) {
        return studentMapper.getByRegistration(registrationId);
    }

    @Override
    public Collection<Student> getAll() {
        return studentMapper.getAll();
    }

    @Override
    public void create(Student student) throws StudentAlreadyExistsException, OperationNotCompleteException {
        Optional<Student> studentExists = Optional.ofNullable(studentMapper.getByCPF(student.getCpf()));
        if(studentExists.isPresent()) {
            throw new StudentAlreadyExistsException(Student.MSG_STUDENT_ALREADY_EXIST);
        }
        try{
            studentMapper.create(student);
        } catch (Exception exception) {
            throw new OperationNotCompleteException(Student.MSG_STUDENT_CREATE_NOT_COMPLETED);
        }
    }

    @Override
    public void update(Student student) throws OperationNotCompleteException {
        try {
            studentMapper.update(student);
        } catch (Exception exception) {
            throw new OperationNotCompleteException(Student.MSG_STUDENT_UPDATE_NOT_COMPLETED);
        }
    }

    @Override
    public void delete(Long registrationId) throws OperationNotCompleteException {
        try{
            studentMapper.destroy(registrationId);
        } catch (Exception exception) {
            throw new OperationNotCompleteException(Student.MSG_STUDENT_DELETE_NOT_COMPLETED);
        }
    }
}
