package com.sajaya.backend.SJA.service;

import com.sajaya.backend.SJA.mapper.PublisherMapper;
import com.sajaya.backend.SJA.model.Publisher;
import com.sajaya.backend.SJA.repository.PublisherRepository;
import com.sajaya.backend.SJA.repository.fetchutils.publisherComplete;
import com.sajaya.backend.SJA.service.dtos.PublisherDto;
import com.sajaya.backend.SJA.service.dtos.PublisherResponseDto;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImp implements PublisherService{
  final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    public PublisherServiceImp(PublisherRepository publisherRepository, PublisherMapper publisherMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherMapper = publisherMapper;
    }

    @Override
    public publisherComplete findByLastName(String lastName) {
       return publisherRepository.findByLastName(lastName,publisherComplete.class); // you can use DTo , interface or record to fetch Data
    }

    @Override
    public PublisherResponseDto savePublisher(Publisher publisherDto) {
        Publisher save = publisherRepository.save(publisherDto);
        return publisherMapper.mapToResponseDto(save);
    }


}
