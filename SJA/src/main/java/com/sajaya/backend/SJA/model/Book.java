package com.sajaya.backend.SJA.model;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookSeq")
    @SequenceGenerator(name = "bookSeq", sequenceName = "book_sequence", allocationSize = 1)
    private Long bookId;


    @NotBlank(message = "Title cannot be blank")
    @Size(max = 30, message = "Title cannot exceed 30 characters")
    @Column(name = "title", length = 30, nullable = false)
    private String title;
    @Column
    private LocalDate publishDate;


}
