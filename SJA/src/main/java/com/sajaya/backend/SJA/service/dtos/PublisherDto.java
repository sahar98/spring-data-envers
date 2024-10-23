package com.sajaya.backend.SJA.service.dtos;

import com.sajaya.backend.SJA.enums.Membership;
import com.sajaya.backend.SJA.model.Book;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class PublisherDto {
    private Long id;
    private String publisherCode;

    private String firstName;

    private String lastName;

    private List<BookDto> books;

    private String nationalCode;

    @Schema(defaultValue = "MAIN_MEMBER,GUEST_MEMBER ")
    private Membership membership;
}
