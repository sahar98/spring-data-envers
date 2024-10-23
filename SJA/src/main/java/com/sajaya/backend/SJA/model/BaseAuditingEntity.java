package com.sajaya.backend.SJA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.sajaya.backend.SJA.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDate;
import java.time.ZonedDateTime;


@MappedSuperclass
@Audited
@Data
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = { "createdBy", "createdDate", "lastModifiedBy" }, callSuper = false)
@ToString(of = { "createdBy", "createdDate", "lastModifiedBy" })
@SuperBuilder
@NoArgsConstructor
public abstract class BaseAuditingEntity implements BaseEntity
{

 private static final long serialVersionUID = 1L;

/*    @Version
    @Column(name = "VERSION", precision = 15, scale = 0)
    private Long version;*/

 @CreatedBy
 @Column(name = "CREATED_BY", length = 50, updatable = false)
 @JsonIgnore
 private Long createdBy = 0L;

 @CreatedDate
 @Column(name = "CREATED_DATE")
 @JsonIgnore
 private LocalDate createdDate ;

 @LastModifiedBy
 @Column(name = "LAST_MODIFIED_BY", length = 50)
 @JsonIgnore
 private Long lastModifiedBy;


 @LastModifiedDate
 @Column(name = "LAST_MODIFIED_DATE")
 @JsonIgnore
 private LocalDate lastModifiedDate ;

}