package com.sajaya.backend.SJA.repository;

import com.sajaya.backend.SJA.model.Publisher;
import org.hibernate.envers.RevisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface PublisherRepository extends RevisionRepository<Publisher, Long, Long>,JpaRepository<Publisher,Long> {

    <T> T findByLastName(String lastName, Class<T> type);






}



