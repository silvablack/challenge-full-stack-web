package com.grupoa.desafio.controller;

import com.grupoa.desafio.exception.ResourceNotFoundException;
import com.grupoa.desafio.model.Institution;
import com.grupoa.desafio.service.impl.InstitutionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Collections;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InstitutionControllerTest {
    private InstitutionController institutionController;
    private InstitutionServiceImpl institutionService;

    @Before
    public void setup() {
        institutionService = Mockito.mock(InstitutionServiceImpl.class);
        institutionController = new InstitutionController(institutionService);
    }

    private Institution createInstitution() {
        return Institution.builder()
                .id(1L)
                .description("EdTech")
                .active(true).build();
    }

    @Test
    public void shouldTestGetAllInstitutions () throws ResourceNotFoundException {
        // scene
        Collection<Institution> expectedInstitutions = Collections.singletonList(createInstitution());
        Mockito.when(institutionService.getAllInstitutions()).thenReturn(expectedInstitutions);

        // execution
        ResponseEntity<Collection<Institution>> resultResponseGetInstitutions = institutionController.getAllInstitutions();

        //test
        Assertions.assertEquals(expectedInstitutions, resultResponseGetInstitutions.getBody());
    }
}
