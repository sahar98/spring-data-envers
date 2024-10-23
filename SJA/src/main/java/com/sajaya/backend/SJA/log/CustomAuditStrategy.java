package com.sajaya.backend.SJA.log;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.configuration.Configuration;
import org.hibernate.envers.internal.entities.mapper.PersistentCollectionChangeData;
import org.hibernate.envers.internal.entities.mapper.relation.MiddleComponentData;
import org.hibernate.envers.internal.entities.mapper.relation.MiddleIdData;
import org.hibernate.envers.internal.tools.query.Parameters;
import org.hibernate.envers.internal.tools.query.QueryBuilder;
import org.hibernate.envers.strategy.spi.AuditStrategy;
import org.hibernate.persister.entity.EntityPersister;

import java.io.Serializable;

public class CustomAuditStrategy implements AuditStrategy {
    @PersistenceContext
    private EntityManager entityManager;

    public void perform(SessionImplementor session,
                        String entityName,
                        Object propertyValue,
                        EntityPersister entityPersister,
                        Object revision,
                        Number revisionNumber,
                        RevisionType revisionType,
                        Object entity) {
        Object oldEntity = fetchOldEntity(entityPersister, entity);

        if (oldEntity != null) {
            // Log old and new entity values
            System.out.println("xgbfgnbdhn");
      //      logChanges(oldEntity, entity);
        }
    }
    private Object fetchOldEntity(EntityPersister entityPersister, Object entity) {
        Serializable entityId = (Serializable) entityPersister.getIdentifier(entity, null);

        // Use EntityManager to find the old entity by ID
        return entityManager.find(entity.getClass(), entityId);
    }
    @Override
    public void perform(Session session, String s, Configuration configuration, Object o, Object o1, Object o2) {
        System.out.println("jdfgvsjkdfhgvkjsdfgb");
    }

    @Override
    public void performCollectionChange(Session session, String s, String s1, Configuration configuration, PersistentCollectionChangeData persistentCollectionChangeData, Object o) {

    }

    @Override
    public void addEntityAtRevisionRestriction(Configuration configuration, QueryBuilder queryBuilder, Parameters parameters, String s, String s1, boolean b, MiddleIdData middleIdData, String s2, String s3, String s4, String s5, boolean b1) {

    }

    @Override
    public void addAssociationAtRevisionRestriction(QueryBuilder queryBuilder, Parameters parameters, String s, String s1, boolean b, MiddleIdData middleIdData, String s2, String s3, String s4, String s5, String s6, boolean b1, MiddleComponentData... middleComponentData) {

    }
}
