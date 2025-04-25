package com.betrybe.alexandria.controllers;

import com.betrybe.alexandria.controllers.dto.PublisherDto;
import com.betrybe.alexandria.controllers.dto.PublisherCreationDto;
import com.betrybe.alexandria.entities.Publisher;
import com.betrybe.alexandria.exceptions.PublisherNOtFoundException;
import com.betrybe.alexandria.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/{id}")
    public PublisherDto getPublisherById(@PathVariable Long id) throws PublisherNOtFoundException {
        Publisher publisherDb = publisherService.findById(id);
        return PublisherDto.fromEntity(publisherDb);
    }

    @GetMapping
    public List<PublisherDto> getAllPublishers() {
        List<Publisher> allPublishers = publisherService.findAll();
        return allPublishers.stream().map(PublisherDto::fromEntity).toList();
    }

    @PostMapping
    public PublisherDto createPublisher(@RequestBody PublisherCreationDto publisherCreationDto)
    throws PublisherNOtFoundException {
        Publisher publisherDb = publisherService.create(PublisherCreationDto.toEntity(publisherCreationDto));
        return PublisherDto.fromEntity(publisherDb);
    }

    @PutMapping("/{id}")
    public PublisherDto updatePublisher(@PathVariable Long id, @RequestBody PublisherCreationDto publisherCreationDto)
        throws PublisherNOtFoundException {
        Publisher publisherDb = publisherService.update(PublisherCreationDto.toEntity(publisherCreationDto), id);
        return PublisherDto.fromEntity(publisherDb);
    }

    @DeleteMapping("/{id}")
    public PublisherDto deletePublisher(@PathVariable Long id) throws PublisherNOtFoundException {
        Publisher publisherDb = publisherService.deleteById(id);
        return PublisherDto.fromEntity(publisherDb);
    }
}
