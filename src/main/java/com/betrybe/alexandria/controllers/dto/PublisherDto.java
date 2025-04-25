package com.betrybe.alexandria.controllers.dto;

import com.betrybe.alexandria.entities.Publisher;

public record PublisherDto (
        Long id,
        String name,
        String address
) {
    public static PublisherDto fromEntity (Publisher publisher) {
        return new PublisherDto(
                publisher.getId(),
                publisher.getName(),
                publisher.getAddress()
        );
    }
}
