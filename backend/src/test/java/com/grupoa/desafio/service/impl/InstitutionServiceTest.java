package com.grupoa.desafio.service.impl;


import com.grupoa.desafio.mapper.InstitutionMapper;
import com.grupoa.desafio.model.Institution;
import com.grupoa.desafio.service.impl.InstitutionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Collections;

public class InstitutionServiceTest {
    private InstitutionMapper institutionMapper;
    private InstitutionServiceImpl institutionService;

    @Before
    public void setup() {
        institutionMapper = Mockito.mock(InstitutionMapper.class);
        institutionService = new InstitutionServiceImpl(institutionMapper);
    }

    private Institution createInstitution() {
        return Institution.builder()
                .id(1L)
                .description("EdTech")
                .active(true).build();
    }

    @Test
    public void shouldReturnCollectionOfInstitution () {
        // scene
        Collection<Institution> expectedInstitutions = Collections.singletonList(createInstitution());
        Mockito.when(institutionMapper.getAllInstitutions()).thenReturn(expectedInstitutions);

        // execution
        Collection<Institution> institutions = institutionService.getAllInstitutions();

        // test
        Assertions.assertEquals(expectedInstitutions, institutions);
    }
}
