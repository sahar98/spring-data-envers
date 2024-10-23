package com.sajaya.backend.SJA.service;

import com.sajaya.backend.SJA.enums.Membership;
import com.sajaya.backend.SJA.model.Book;
import com.sajaya.backend.SJA.model.Publisher;
import com.sajaya.backend.SJA.repository.fetchutils.publisherComplete;
import com.sajaya.backend.SJA.service.dtos.BookDto;
import com.sajaya.backend.SJA.service.dtos.PublisherDto;
import com.sajaya.backend.SJA.service.dtos.PublisherResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

class publisherServiceImpTest {
    @Autowired
    publisherServiceImp publisherService;



    @Test
    void findByLastName() {
        PublisherDto publisherDto = fillPublisherDto();
        publisherService.savePublisher(publisherDto);
        publisherComplete publisherComplete = publisherService.findByLastName("احمدی");
        assertEquals("احمدی" ,publisherComplete.lastName());
    }

    @Test
    public void testSavePublisher() {
        PublisherDto publisherDto = fillPublisherDto();
        PublisherResponseDto expectedResponse = fillPublisherResponseDto();

        // Act
        PublisherResponseDto result = publisherService.savePublisher(publisherDto);

        // Assert
       assertEquals(expectedResponse, result);
       assertThat(result).isEqualToComparingFieldByFieldRecursively (expectedResponse);

    }

    public PublisherResponseDto fillPublisherResponseDto() {

        PublisherResponseDto publisherDto = new PublisherResponseDto();
        publisherDto.setId(1L);
        publisherDto.setPublisherCode("12345678");
        publisherDto.setFirstName("احمد");
        publisherDto.setLastName("احمدی");
        publisherDto.setNationalCode("987654321");
        publisherDto.setMembership(Membership.GUEST_MEMBER);
        List<BookDto> bookDtos = new ArrayList<>();
        List<BookDto> books = new ArrayList<>();
        BookDto book1 = new BookDto();
          book1.setBookId(1L);
        book1.setTitle("Test Book 1");
        book1.setPublishDate(LocalDate.of(2023, 1, 1));
        BookDto book2 = new BookDto();
         book2.setBookId(2L);
        book2.setTitle("Test Book 2");
        book2.setPublishDate(LocalDate.of(2023, 2, 1));
        books.add(book1);
        books.add(book2);
        publisherDto.setBooks(bookDtos);
        return publisherDto;

    }

    public PublisherDto fillPublisherDto() {
        PublisherDto publisherDto = new PublisherDto();
        publisherDto.setPublisherCode("12345678");
        publisherDto.setFirstName("احمد");
        publisherDto.setLastName("احمدی");
        publisherDto.setNationalCode("987654321");
        publisherDto.setMembership(Membership.GUEST_MEMBER);
        List<BookDto> bookDtos = new ArrayList<>();
        List<BookDto> books = new ArrayList<>();
        BookDto book1 = new BookDto();
        book1.setTitle("Test Book 1");
        book1.setPublishDate(LocalDate.of(2023, 1, 1));
        BookDto book2 = new BookDto();
        book2.setTitle("Test Book 2");
        book2.setPublishDate(LocalDate.of(2023, 2, 1));
        books.add(book1);
        books.add(book2);
        publisherDto.setBooks(bookDtos);
        return publisherDto;

    }



}