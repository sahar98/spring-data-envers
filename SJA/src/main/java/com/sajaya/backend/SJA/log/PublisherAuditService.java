package com.sajaya.backend.SJA.log;

import com.sajaya.backend.SJA.model.Publisher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PublisherAuditService {

    @PersistenceContext
    private EntityManager entityManager;

 /*   public List printPublisherChangeLog(Long publisherId) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        AuditQuery q = auditReader.createQuery().forRevisionsOfEntity(Publisher.class, true, true);
        q.add(AuditEntity.id().eq(publisherId));
        //q.add(AuditEntity.relatedId("mainId").eq(publisherId));
        // Retrieve all revision numbers for this entity

      *//*  if (dto.getFromDate() != 0 && dto.getToDate() != 0)
            q.add(AuditEntity.property("last_modify").between(dto.getFromDate(), dto.getToDate()));
        else if (dto.getToDate() != 0)
            q.add(AuditEntity.property("last_modify").le(dto.getToDate()));
        else if (dto.getFromDate() != 0)
            q.add(AuditEntity.property("last_modify").ge(dto.getFromDate()));*//*
        //   int totalSize = q.getResultList().size();
        q.addOrder(AuditEntity.revisionNumber().asc());
        // q.setFirstResult((dto.getPage() - 1) * dto.getSize()).setMaxResults(dto.getSize());
        return q.getResultList();
        *//*List<Number> revisions = auditReader.getRevisions(Publisher.class, publisherId);

        for (int i = 1; i < revisions.size(); i++) {
            // Retrieve the "old" entity state (previous revision)
            Publisher oldPublisher = auditReader.find(Publisher.class, publisherId, revisions.get(i - 1));

            // Retrieve the "new" entity state (current revision)
            Publisher newPublisher = auditReader.find(Publisher.class, publisherId, revisions.get(i));

            System.out.println("Comparing Revisions: " + revisions.get(i - 1) + " and " + revisions.get(i));
            System.out.println("Old Value - family: " + oldPublisher.getLastName() + ", family: " + oldPublisher.getLastName());
            System.out.println("New Value - nationalcode: " + newPublisher.getPublisherCode() + ", nationalcode: " + newPublisher.getPublisherCode());
            System.out.println("time :" + newPublisher.getTimestamp());
            System.out.println("-----");

   *//**//*         // Additional comparison and logging can be done here
            if (!oldPublisher.getName().equals(newPublisher.getName())) {
                System.out.println("Name changed from " + oldPublisher.getName() + " to " + newPublisher.getName());
            }

            if (!oldPublisher.getAddress().equals(newPublisher.getAddress())) {
                System.out.println("Address changed from " + oldPublisher.getAddress() + " to " + newPublisher.getAddress());
            }*//**//*
        }*//*
    }*/

    public List<Object[]> printPublisherChangeLog(Long publisherId) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        AuditQuery q = auditReader.createQuery()
                .forRevisionsOfEntity(Publisher.class, false, true)
                .add(AuditEntity.id().eq(publisherId))
                .addProjection(AuditEntity.revisionType())
               .addProjection(AuditEntity.revisionProperty("timestamp"))

                ;
        q.add(AuditEntity.relatedId("mainId").eq(publisherId));
        List<Object[]> results = q.getResultList();
/*        for (Object[] revisionData : results) {
            // Cast the results correctly
            Publisher publisher = (Publisher) revisionData[0];
            RevisionType revisionType = (RevisionType) revisionData[1];
            Long timestamp = (Long) revisionData[2];

            // Print action type and timestamp

            System.out.println("revisionType" +revisionType);
        }*/

   /*         System.out.println("Comparing Revisions: " + (i - 1) + " and " + i);
            System.out.println("Action Type: " + revisionType.name());
            System.out.println("Old Value - Name: " + oldPublisher.getName() + ", Address: " + oldPublisher.getAddress());
            System.out.println("New Value - Name: " + newPublisher.getName() + ", Address: " + newPublisher.getAddress());
            System.out.println("-----");

            // Compare fields and log changes
            if (!oldPublisher.getName().equals(newPublisher.getName())) {
                System.out.println("Name changed from " + oldPublisher.getName() + " to " + newPublisher.getName());
            }
            if (!oldPublisher.getAddress().equals(newPublisher.getAddress())) {
                System.out.println("Address changed from " + oldPublisher.getAddress() + " to " + newPublisher.getAddress());
            }*/
            return results;
        }






/*

    public SearchResultModel<MemoryUniqueIdWebModel> loadAudit(LoadAuditDto dto, String currentOrg) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        AuditQuery q = auditReader.createQuery().forRevisionsOfEntity(MemoryUniqueIdEntity.class, true, true);
        q.add(AuditEntity.id().eq(dto.getId()));
        q.add(AuditEntity.relatedId("mainId").eq(currentOrg));

        if (dto.getFromDate() != 0 && dto.getToDate() != 0)
            q.add(AuditEntity.property(MemoryUniqueIdEntity_.LAST_MODIFIED_DATE).between(dto.getFromDate(), dto.getToDate()));
        else if (dto.getToDate() != 0)
            q.add(AuditEntity.property(MemoryUniqueIdEntity_.LAST_MODIFIED_DATE).le(dto.getToDate()));
        else if (dto.getFromDate() != 0)
            q.add(AuditEntity.property(MemoryUniqueIdEntity_.LAST_MODIFIED_DATE).ge(dto.getFromDate()));
        int totalSize = q.getResultList().size();

        q.addOrder(AuditEntity.revisionNumber().asc());
        q.setFirstResult((dto.getPage() - 1) * dto.getSize()).setMaxResults(dto.getSize());

        PaginationModel pagination = new PaginationModel();
        pagination.setPage(dto.getPage());
        pagination.setSize(dto.getSize());
        pagination.setTotal((long) totalSize);

        SearchResultModel<MemoryUniqueIdWebModel> searchResultModel = new SearchResultModel<>();
        searchResultModel.setResult(mapper.toModels((List<MemoryUniqueIdEntity>) q.getResultList()));
        searchResultModel.setPagination(pagination);

        return searchResultModel;
    }
```
    */
 //   }


}

