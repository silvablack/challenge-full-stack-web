package com.grupoa.desafio.service.impl;

import com.grupoa.desafio.mapper.InstitutionMapper;
import com.grupoa.desafio.model.Institution;
import com.grupoa.desafio.service.InstitutionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionMapper institutionMapper;

    @Override
    public Collection<Institution> getAllInstitutions () {
        return institutionMapper.getAllInstitutions();
    }
}
