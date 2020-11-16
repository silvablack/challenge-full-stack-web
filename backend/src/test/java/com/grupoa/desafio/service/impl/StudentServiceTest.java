package com.grupoa.desafio.service.impl;

import com.grupoa.desafio.exception.OperationNotCompleteException;
import com.grupoa.desafio.exception.StudentAlreadyExistsException;
import com.grupoa.desafio.mapper.StudentMapper;
import com.grupoa.desafio.model.Student;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class StudentServiceTest {
    private StudentMapper studentMapper;
    private StudentServiceImpl studentService;

    @Before
    public void setup() {
        studentMapper = Mockito.mock(StudentMapper.class);
        studentService = new StudentServiceImpl(studentMapper);
    }

    private Student createStudent() {
        return Student.builder()
                .registration(1L)
                .name("Miguel")
                .cpf("01122233344")
                .email("miguel@gmail.com")
                .active(true)
                .build();
    }

    @Test
    public void shouldCreateAStudentService () throws OperationNotCompleteException, StudentAlreadyExistsException {
        // scene
        Student student = createStudent();
        Mockito.when(studentMapper.getByCPF(student.getCpf())).thenReturn(null);
        Mockito.doNothing().when(studentMapper).create(student);

        // execution
        studentService.create(student);
    }

    @Test(expected = StudentAlreadyExistsException.class)
    public void shouldExceptionStudentAlreadyExistService () throws OperationNotCompleteException, StudentAlreadyExistsException {
        // scene
        Student student = createStudent();
        Mockito.when(studentMapper.getByCPF(student.getCpf())).thenReturn(student);
        Mockito.doNothing().when(studentMapper).create(student);

        // execution
        studentService.create(student);
    }
}
