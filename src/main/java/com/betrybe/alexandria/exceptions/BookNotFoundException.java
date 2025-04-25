package com.betrybe.alexandria.exceptions;

public class BookNotFoundException extends NotFoundException {
    public BookNotFoundException() {
        super("Book not found");
    }
}
