package com.sajaya.backend.SJA.mapper;

import com.sajaya.backend.SJA.mapper.annotation.IgnoreMappingBase;
import com.sajaya.backend.SJA.model.Publisher;
import com.sajaya.backend.SJA.service.dtos.PublisherDto;
import com.sajaya.backend.SJA.service.dtos.PublisherResponseDto;
import org.mapstruct.*;
@Mapper(componentModel = "spring")
public interface PublisherMapper {
   // @Mapping(target = "id", ignore = true)
    Publisher mapToModel(PublisherDto publisherDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    PublisherResponseDto mapToResponseDto(Publisher publisher);
}
