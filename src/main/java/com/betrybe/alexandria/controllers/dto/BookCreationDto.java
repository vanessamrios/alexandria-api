package com.betrybe.alexandria.controllers.dto;

import com.betrybe.alexandria.entities.Book;

public record BookCreationDto (
        String title,
        String genre) {

    public Book toEntity() {
        return new Book(title, genre);
    }
}
