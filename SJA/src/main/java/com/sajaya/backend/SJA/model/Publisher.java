package com.sajaya.backend.SJA.model;

import com.sajaya.backend.SJA.enums.Membership;
import com.sajaya.backend.SJA.log.AuditListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.util.List;

@Data
@Entity
@Table
@AuditTable(value = "Publisher_AUD")
@Audited
@EntityListeners(AuditListener.class)
public class Publisher {


    @Id

    private Long id;
    @NotBlank(message = "Title cannot be blank")
    @Size(max = 10, message = "Title cannot exceed 10 characters")
    private String publisherCode;
    @NotBlank(message = "Title cannot be blank")
    @Size(max = 20, message = "Title cannot exceed 20 characters")
    @Column(length = 20, nullable = false)
    private String firstName;
    @NotBlank(message = "Title cannot be blank")
    @Size(max = 20, message = "Title cannot exceed 20 characters")
    @Column(length = 20, nullable = false)
    private String lastName;
    @NotAudited
    @OneToMany(cascade = CascadeType.ALL) // cascade depends on your business
    @JoinColumn(name = "publisher_id")
    // default value must be LAZY - if you need all data plz use entityGraph or other one
    private List<Book> books;
    @NotBlank(message = "Title cannot be blank")
    @Size(max = 10, message = "Title cannot exceed 10 characters")
    private String nationalCode;
    @Enumerated(EnumType.STRING)
    @Column
    //@Audited
    private Membership membership;

  //  @Version Long version;

}
