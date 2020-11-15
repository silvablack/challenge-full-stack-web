package com.grupoa.desafio.mapper;

import com.grupoa.desafio.model.Institution;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface InstitutionMapper {
    Collection<Institution> getAllInstitutions();
}
