package com.grupoa.desafio.exception.handler;

import com.grupoa.desafio.exception.OperationNotCompleteException;
import com.grupoa.desafio.exception.ResourceNotFoundException;
import com.grupoa.desafio.exception.StudentAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> resourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resourceNotFoundException.getMessage());
    }

    @ExceptionHandler({OperationNotCompleteException.class})
    public ResponseEntity<String> operationNotCompleteExceptionHandler(OperationNotCompleteException operationNotCompleteException){
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(operationNotCompleteException.getMessage());
    }

    @ExceptionHandler({StudentAlreadyExistsException.class})
    public ResponseEntity<String> studentAlreadyExistsExceptionHandler(StudentAlreadyExistsException studentAlreadyExistsException){
        return ResponseEntity.status(HttpStatus.FOUND).body(studentAlreadyExistsException.getMessage());
    }
}
