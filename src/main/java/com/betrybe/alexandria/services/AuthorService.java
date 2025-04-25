package com.betrybe.alexandria.services;

import com.betrybe.alexandria.entities.Author;
import com.betrybe.alexandria.exceptions.AuthorNotFoundException;
import com.betrybe.alexandria.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author findById(Long id) throws AuthorNotFoundException {
        return authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author create(Author author) {
        return authorRepository.save(author);
    }

    public Author update(Long id, Author author) throws AuthorNotFoundException {
        Author authorDB = authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);

        authorDB.setName(author.getName());
        authorDB.setNationality(author.getNationality());

        return authorRepository.save(authorDB);
    }

    public Author deleteById(Long id) throws AuthorNotFoundException {
        Author authorDB = authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);

        authorRepository.deleteById(id);

        return authorDB;
    }
}
