package com.solid.example.mapper;

import com.solid.example.dto.PersonRequest;
import com.solid.example.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "id", ignore = true)
    Person toPerson(PersonRequest personRequest);
}
