package com.sajaya.backend.SJA.mapper;

import com.sajaya.backend.SJA.model.Publisher;
import com.sajaya.backend.SJA.service.dtos.PublisherDto;
import com.sajaya.backend.SJA.service.dtos.PublisherResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-22T13:31:26+0330",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class PublisherMapperImpl implements PublisherMapper {

    @Override
    public Publisher mapToModel(PublisherDto publisherDto) {
        if ( publisherDto == null ) {
            return null;
        }

        Publisher publisher = new Publisher();

        return publisher;
    }

    @Override
    public PublisherResponseDto mapToResponseDto(Publisher publisher) {
        if ( publisher == null ) {
            return null;
        }

        PublisherResponseDto publisherResponseDto = new PublisherResponseDto();

        return publisherResponseDto;
    }
}
