package com.betrybe.alexandria.controllers.dto;

import com.betrybe.alexandria.entities.Author;

public record AuthorDto (
        Long id,
        String name,
        String nationality
) {
    public static AuthorDto fromEntity (Author author) {
        return new AuthorDto(
                author.getId(),
                author.getName(),
                author.getNationality()
        );
    }
}
