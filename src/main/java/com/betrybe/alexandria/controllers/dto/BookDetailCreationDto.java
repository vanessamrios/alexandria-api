package com.betrybe.alexandria.controllers.dto;

import com.betrybe.alexandria.entities.BookDetail;

public record BookDetailCreationDto (
        String summary,
        Integer pageCount,
        String year,
        String isbn
) {
    public static BookDetail toEntity(BookDetailCreationDto bookDetailCreationDto) {
        return new BookDetail (
                bookDetailCreationDto.summary(),
                bookDetailCreationDto.pageCount(),
                bookDetailCreationDto.year(),
                bookDetailCreationDto.isbn()
        );
    }
}
