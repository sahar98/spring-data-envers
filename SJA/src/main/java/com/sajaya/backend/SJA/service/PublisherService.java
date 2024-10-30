package com.sajaya.backend.SJA.service;

import com.sajaya.backend.SJA.model.Publisher;
import com.sajaya.backend.SJA.repository.fetchutils.publisherComplete;
import com.sajaya.backend.SJA.service.dtos.PublisherDto;

public interface PublisherService {

    publisherComplete findByLastName(String lastName);

    Publisher savePublisher(Publisher publisherDto);

}
