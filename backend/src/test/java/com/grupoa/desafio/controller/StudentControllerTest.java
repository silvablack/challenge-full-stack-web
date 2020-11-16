package com.grupoa.desafio.controller;

import com.grupoa.desafio.exception.OperationNotCompleteException;
import com.grupoa.desafio.exception.ResourceNotFoundException;
import com.grupoa.desafio.exception.StudentAlreadyExistsException;
import com.grupoa.desafio.model.Student;
import com.grupoa.desafio.service.impl.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Collections;

public class StudentControllerTest {
    private StudentController studentController;
    private StudentServiceImpl studentService;

    @Before
    public void setup() {
        studentService = Mockito.mock(StudentServiceImpl.class);
        studentController = new StudentController(studentService);
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
    public void shouldGetAStudent () throws ResourceNotFoundException {
        // scene
        Student expectedStudent = createStudent();
        Mockito.when(studentService.getByRegistration(expectedStudent.getRegistration())).thenReturn(expectedStudent);

        // execution
        ResponseEntity<Student> responseStudent = studentController.getStudent(expectedStudent.getRegistration());

        // test
        Assertions.assertEquals(HttpStatus.OK, responseStudent.getStatusCode());
        Assertions.assertEquals(expectedStudent, responseStudent.getBody());
    }

    @Test
    public void shouldGetAllStudent () throws ResourceNotFoundException {
        // scene
        Collection<Student> expectedStudents = Collections.singletonList(createStudent());
        Mockito.when(studentService.getAll()).thenReturn(expectedStudents);

        // execution
        ResponseEntity<Collection<Student>> responseStudents = studentController.getAllStudents();

        // test
        Assertions.assertEquals(HttpStatus.OK, responseStudents.getStatusCode());
        Assertions.assertEquals(expectedStudents, responseStudents.getBody());
    }

    @Test
    public void shouldCreateNewStudent () throws StudentAlreadyExistsException, OperationNotCompleteException {
        // scene
        Student newStudent = createStudent();
        Mockito.doNothing().when(studentService).create(createStudent());

        // execution
        ResponseEntity<Student> responseStudent = studentController.createStudent(newStudent);

        // test
        Assertions.assertEquals(HttpStatus.CREATED, responseStudent.getStatusCode());
        Assertions.assertEquals(newStudent, responseStudent.getBody());
    }

    @Test
    public void shouldUpdateAStudent () throws OperationNotCompleteException {
        // scene
        Student student = createStudent();
        Mockito.doNothing().when(studentService).update(student);

        // execution
        ResponseEntity<String> responseEntity = studentController.updateStudent(student);

        // test
        Assertions.assertEquals(Student.MSG_STUDENT_UPDATED, responseEntity.getBody());
    }

    @Test
    public void shouldDeleteAStudent () throws OperationNotCompleteException {
        // scene
        Student student = createStudent();
        Mockito.doNothing().when(studentService).delete(student.getRegistration());

        // execution
        ResponseEntity<String> responseEntity = studentController.deleteStudent(student.getRegistration());

        // test
        Assertions.assertEquals(Student.MSG_STUDENT_DELETED, responseEntity.getBody());
    }

}
