package com.betrybe.alexandria.controllers.dto;

import com.betrybe.alexandria.entities.Publisher;

public record PublisherCreationDto (
        String name,
        String address) {
    public static Publisher toEntity(PublisherCreationDto publisherCreationDto) {
        return new Publisher(
                publisherCreationDto.name(),
                publisherCreationDto.address()
        );
    }
}
