package com.betrybe.alexandria.controllers.dto;

import com.betrybe.alexandria.entities.Book;

public record BookDto (
        Long id,
        String title,
        String genre) {

    public static BookDto fromEntity(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getGenre()
        );
    }
}
