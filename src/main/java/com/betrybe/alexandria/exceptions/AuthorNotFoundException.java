package com.betrybe.alexandria.exceptions;

public class AuthorNotFoundException extends NotFoundException {
    public AuthorNotFoundException() {
        super("Author not found");
    }
}
