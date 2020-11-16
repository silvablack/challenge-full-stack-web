package com.grupoa.desafio.controller;

import com.grupoa.desafio.exception.OperationNotCompleteException;
import com.grupoa.desafio.exception.ResourceNotFoundException;
import com.grupoa.desafio.exception.StudentAlreadyExistsException;
import com.grupoa.desafio.model.Student;
import com.grupoa.desafio.service.StudentService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @ApiOperation("GET all students")
    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudents () throws ResourceNotFoundException {
        Optional<Collection<Student>> optionalStudents = Optional.ofNullable(studentService.getAll());
        return optionalStudents.map(students -> ResponseEntity.ok().body(students)
        ).orElseThrow( () -> new ResourceNotFoundException(Student.MSG_STUDENT_NOT_FOUND));
    }
    @ApiOperation("GET student by registration id")
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent (@PathVariable("id") Long studentId) throws ResourceNotFoundException {
        Optional<Student> optionalStudent = Optional.ofNullable(studentService.getByRegistration(studentId));
        return optionalStudent.map(student -> ResponseEntity.ok().body(student)
        ).orElseThrow( () -> new ResourceNotFoundException(Student.MSG_STUDENT_NOT_FOUND));
    }

    @ApiOperation("POST create a new student")
    @PostMapping
    public ResponseEntity<Student> createStudent (@Valid @RequestBody Student student) throws StudentAlreadyExistsException, OperationNotCompleteException {
        student.setActive(true);
        studentService.create(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @ApiOperation("PUT update a student")
    @PutMapping
    public ResponseEntity<String> updateStudent (@RequestBody Student student) throws OperationNotCompleteException {
        studentService.update(student);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Student.MSG_STUDENT_UPDATED);
    }

    @ApiOperation("DELETE destroy a student")
    @DeleteMapping
    public ResponseEntity<String> deleteStudent (@RequestParam("studentId") Long studentId) throws OperationNotCompleteException {
        studentService.delete(studentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Student.MSG_STUDENT_DELETED);
    }
}
