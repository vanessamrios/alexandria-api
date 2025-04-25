package com.betrybe.alexandria.controllers.dto;

import com.betrybe.alexandria.entities.Author;

public record AuthorCreationDto (
        String name,
        String nationality
) {
    public static Author toEntity(AuthorCreationDto authorCreationDto) {
        return new Author(
                authorCreationDto.name(),
                authorCreationDto.nationality()
        );
    }
}
