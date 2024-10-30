package com.sajaya.backend.SJA.log;

import com.sajaya.backend.SJA.model.Publisher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreUpdate;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AuditListener

{
    Logger logger      = LoggerFactory.getLogger(AuditListener.class);



 //   @PreUpdate
  /*  public void logBeforeUpdate(Object entity) {
        if (entity instanceof Publisher) {
            Publisher oldEntity = (Publisher) entity;
            EntityManager entityManager = SpringContext.getBean(EntityManager.class);
            entityManager.detach(oldEntity);
            Publisher updated = fetchOldEntity(oldEntity.getId());
            if (oldEntity != null) {
                // Compare and log the changes
                logger.info("Old entity: " + oldEntity);
                logger.info("New entity: " + updated);
            }
        }

    }*/

    Publisher fetchOldEntity(Long id) {
        try {
            EntityManager entityManager = SpringContext.getBean(EntityManager.class);


            return entityManager.find(Publisher.class, id);

        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle exceptions as needed
        }
    }



}