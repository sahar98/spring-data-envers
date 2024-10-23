package com.sajaya.backend.SJA.service.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDto {
    private Long bookId;
    private String title;
    private LocalDate publishDate;
}
