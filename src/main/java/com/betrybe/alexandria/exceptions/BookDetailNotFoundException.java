package com.betrybe.alexandria.exceptions;

public class BookDetailNotFoundException extends NotFoundException {
    public BookDetailNotFoundException() {
        super("Details not found");
    }
}
