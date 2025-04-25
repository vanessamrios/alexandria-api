package com.betrybe.alexandria.controllers;

import com.betrybe.alexandria.controllers.dto.AuthorCreationDto;
import com.betrybe.alexandria.controllers.dto.AuthorDto;
import com.betrybe.alexandria.entities.Author;
import com.betrybe.alexandria.exceptions.AuthorNotFoundException;
import com.betrybe.alexandria.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable Long id) throws AuthorNotFoundException {
        return AuthorDto.fromEntity(authorService.findById(id));
    }

    @GetMapping
    public List<AuthorDto> getAllAuthors() {
        List<Author> allAuthors = authorService.findAll();
        return allAuthors.stream().map(AuthorDto::fromEntity).toList();
    }

    @PostMapping
    public AuthorDto createAuthor(@RequestBody AuthorCreationDto authorCreationDto) {
        Author authorDb = authorService.create(AuthorCreationDto.toEntity(authorCreationDto));
        return AuthorDto.fromEntity(authorDb);
    }

    @PutMapping("/{id}")
    public AuthorDto updateAuthor(@PathVariable Long id, @RequestBody AuthorCreationDto authorCreationDto)
    throws AuthorNotFoundException {
        Author authorDb = authorService.update(id, AuthorCreationDto.toEntity(authorCreationDto));
        return AuthorDto.fromEntity(authorDb);
    }

    @DeleteMapping("/{id}")
    public AuthorDto deleteAuthor (@PathVariable Long id) throws AuthorNotFoundException {
        Author authorDb = authorService.deleteById(id);
        return AuthorDto.fromEntity(authorDb);
    }
}
