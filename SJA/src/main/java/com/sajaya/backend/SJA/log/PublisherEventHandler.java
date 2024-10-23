package com.sajaya.backend.SJA.log;

import com.sajaya.backend.SJA.model.Publisher;
import com.sajaya.backend.SJA.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.stereotype.Component;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.util.Optional;

@Component
//@RepositoryEventHandler(Publisher.class)
public class PublisherEventHandler {

  private    PublisherRepository publisherRepository;
@Autowired
    public PublisherEventHandler(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

//
//    @HandleBeforeSave
//    public void handleBeforeSave(Publisher customer) {
//        System.out.println("handleBeforeSave :: customer.id = " + customer.getId());
//        System.out.println("handleBeforeSave :: new customer.name = " + customer.getMembership());
//
//        Optional<Publisher> one = publisherRepository.findOne(customer.getId());
//        System.out.println("handleBeforeSave :: new customer.name = " + customer.getId());
//        System.out.println("handleBeforeSave :: old customer.name = " + one.get().getMembership());
//    }
}
