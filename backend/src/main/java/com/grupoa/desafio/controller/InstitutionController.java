package com.grupoa.desafio.controller;

import com.grupoa.desafio.exception.ResourceNotFoundException;
import com.grupoa.desafio.model.Institution;
import com.grupoa.desafio.service.InstitutionService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/api/v1/institution")
public class InstitutionController {

    @Resource
    private final InstitutionService institutionService;

    @ApiOperation("GET all institutions")
    @GetMapping
    public ResponseEntity<Collection<Institution>> getAllInstitutions () throws ResourceNotFoundException {
        Optional<Collection<Institution>> listInstitutions = Optional.ofNullable(institutionService.getAllInstitutions());
        return listInstitutions.map(institutions -> ResponseEntity.ok().body(institutions)
        ).orElseThrow( () -> new ResourceNotFoundException("No institutions found"));
    }
}
