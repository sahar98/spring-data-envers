package com.sajaya.backend.SJA.api;

import com.sajaya.backend.SJA.model.Publisher;
import com.sajaya.backend.SJA.repository.fetchutils.publisherComplete;
import com.sajaya.backend.SJA.service.PublisherService;
import com.sajaya.backend.SJA.service.dtos.PublisherDto;
import com.sajaya.backend.SJA.service.dtos.PublisherResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Tag(name="publisher")
public class publisherController {
final PublisherService publisherService;
    private final com.sajaya.backend.SJA.service.publisherServiceImp publisherServiceImp;


/*    @Operation(description = "Create GradeLock for EducationalClass.")
    @PostMapping("/publisher/savePublisher")
    PublisherResponseDto save(@RequestBody @Valid PublisherDto publisherDto) {

        publisherDto.setPublisherCode("5t6345654");
        publisherDto.setFirstName("dfgbsd");
        publisherDto.setPublisherCode("dfghsf");
        publisherDto.setLastName("dfgsdtg");

              return publisherServiceImp.savePublisher(publisherDto);
    }*/

    @Operation(description = "Create GradeLock for EducationalClass.")
    @PutMapping("/publisher/EditPublisher")
    PublisherResponseDto edit(@RequestBody Publisher publisherDto) {
        return publisherServiceImp.savePublisher(publisherDto);
    }
    @GetMapping("/publisher/getPublisherInfo")
    publisherComplete getPublisherInfo(@RequestParam String lastName) {
        return publisherService.findByLastName(lastName);
    }
}
