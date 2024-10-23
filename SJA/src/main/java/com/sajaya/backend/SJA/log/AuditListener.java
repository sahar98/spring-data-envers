package com.sajaya.backend.SJA.log;

import com.sajaya.backend.SJA.model.Publisher;
import com.sajaya.backend.SJA.repository.PublisherRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreUpdate;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.stereotype.Component;
import org.w3c.dom.events.Event;

import java.util.Optional;

@Component
public class AuditListener
        // implements RevisionListener
{
    @Autowired
    PublisherRepository publisherRepository;
   /* @PrePersist


    @PreRemove
    private void beforeAnyOperation(Object object) {
        System.out.println("aAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }*/


    @PreUpdate
    public void logBeforeUpdate(Object entity) {
        if (entity instanceof Publisher) {
            Publisher updatedEntity = (Publisher) entity;
            //    EntityManager entityManager = SpringContext.getBean(EntityManager.class);
            // Fetch the old version from the database
            //  Publisher oldEntity = entityManager.find(Publisher.class, updatedEntity.getId());
          /*  EntityManager entityManager = SpringContext.getBean(EntityManager.class);

           AuditReader reader = AuditReaderFactory.get( entityManager );

            Publisher oldEntity = reader.find( Publisher.class, updatedEntity.getId(), 1 );*/
            PublisherRepository publisherRepository = SpringContext.getBean(PublisherRepository.class);
            Optional<Revision<Long, Publisher>> lastChangeRevision = publisherRepository.findLastChangeRevision(updatedEntity.getId());

            // Publisher oldEntity = fetchOldEntity(entity);
            if (lastChangeRevision.get().getEntity() != null) {
                // Compare and log the changes
         /*       logger.info("Old entity: " + oldEntity);
                logger.info("New entity: " + updatedEntity);*/
            }
        }

    }

    private Publisher fetchOldEntity(Object entity) {
        try {
            EntityManager entityManager = SpringContext.getBean(EntityManager.class);

   /*         Publisher revisionEntity = (Publisher) ((Object[]) AuditReaderFactory
                    .get(entityManager)
                    .createQuery()
                    .forRevisionsOfEntity(Publisher.class, false, false)
                    .add(AuditEntity.id().eq(1L))
                    .getResultList()
                    .get(3))
                    [1];*/

           /* Long id = (Long) entity.getClass().getMethod("getId").invoke(entity);

              return    (Publisher) entityManager.find(entity.getClass(), id);*/

            AuditReader reader = AuditReaderFactory.get(entityManager);
            //     Event firstRevision = reader.find( Event.class, , 1 );

            Publisher secondRevision = reader.find(Publisher.class, 2L, 2);
            return new Publisher();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle exceptions as needed
        }
    }

   /* @Override
    public void newRevision(Object o) {

    }*/


}