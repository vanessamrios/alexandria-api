package com.betrybe.alexandria.controllers.dto;

import com.betrybe.alexandria.entities.BookDetail;

public record BookDetailDto (
        Long id,
        String summary,
        Integer pageCount,
        String year,
        String isbn) {

    public static BookDetailDto fromEntity(BookDetail bookDetail) {
        return new BookDetailDto(
                bookDetail.getId(),
                bookDetail.getSummary(),
                bookDetail.getPageCount(),
                bookDetail.getYear(),
                bookDetail.getIsbn()
        );
    }
}
