package com.sajaya.backend.SJA.repository;

import com.sajaya.backend.SJA.model.DocumentExpirationInfoEntity;
import com.sajaya.backend.SJA.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocRepository extends JpaRepository<DocumentExpirationInfoEntity,Long> {
}
