package com.sajaya.backend.SJA.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import java.time.LocalDate;

@Entity
@Table(name = "TB_DOCUMENT_EXPIRATION_INFO")
@Data
@EqualsAndHashCode(callSuper = false)
@Audited
@AuditTable(value = "TB_DOCUMENT_EXPIRATION_INFO_AUD")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentExpirationInfoEntity extends BaseAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "SQ_DOCUMENT_EXPIRATION_INFO", allocationSize = 1)
    @Column(name = "ID", unique = true, nullable = false, precision = 10)
    private Long id;
    @Column(name = "EXPIRE_DATE", length = 10)
    private LocalDate expireDate;
    @Column(name = "DESCRIPTION", length = 500)
    private String description;
    @Column(name = "IDENTITY_DOCUMENT_ID")
    private String docNumber;

//    @Version//    @Column(name = "VERSION")//    private Long version;}
}