package com.betrybe.alexandria.controllers;

import com.betrybe.alexandria.controllers.dto.BookCreationDto;
import com.betrybe.alexandria.controllers.dto.BookDetailCreationDto;
import com.betrybe.alexandria.controllers.dto.BookDetailDto;
import com.betrybe.alexandria.controllers.dto.BookDto;
import com.betrybe.alexandria.entities.Book;
import com.betrybe.alexandria.entities.BookDetail;
import com.betrybe.alexandria.exceptions.BookDetailNotFoundException;
import com.betrybe.alexandria.exceptions.BookNotFoundException;
import com.betrybe.alexandria.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) throws BookNotFoundException {
        Book bookDB = bookService.findById(id);
        return BookDto.fromEntity(bookDB);
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        List<Book> allBooks = bookService.findAll();
        return allBooks.stream().map(BookDto::fromEntity).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody BookCreationDto bookCreationDTO) {
        return BookDto.fromEntity(bookService.create(bookCreationDTO.toEntity()));
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Long id, @RequestBody BookCreationDto bookCreationDto) throws BookNotFoundException {
        return BookDto.fromEntity(bookService.update(bookCreationDto.toEntity(), id));
    }

    @DeleteMapping("/{id}")
    public BookDto deleteBookById(@PathVariable Long id) throws BookNotFoundException {
        return BookDto.fromEntity(bookService.deleteById(id));
    }

    @PostMapping("/{bookId}/detail")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDetailDto createBookDetail (@PathVariable Long bookId, @RequestBody BookDetailCreationDto bookDetailCreationDto)
    throws BookNotFoundException {
        BookDetail bookDetail = bookService.createBookDetail(bookId, BookDetailCreationDto.toEntity(bookDetailCreationDto));
        return BookDetailDto.fromEntity(bookDetail);
    }

    @GetMapping("/{bookId}/detail")
    public BookDetailDto getBookDetail(@PathVariable Long bookId)
    throws BookNotFoundException, BookDetailNotFoundException {
        BookDetail bookDetail = bookService.getBookDetail(bookId);
        return BookDetailDto.fromEntity(bookDetail);
    }

    @PutMapping("/{bookId}/detail")
    public BookDetailDto updateBookDetail(@PathVariable Long bookId, @RequestBody BookDetailCreationDto bookDetailCreationDto)
    throws BookDetailNotFoundException, BookNotFoundException {
        BookDetail bookDetailDB = bookService.updateBookDetail(bookId, BookDetailCreationDto.toEntity(bookDetailCreationDto));
        return BookDetailDto.fromEntity(bookDetailDB);
    }

    @DeleteMapping("/{bookId}/detail")
    public BookDetailDto deleteBookDetail (@PathVariable Long bookId)
    throws BookNotFoundException, BookDetailNotFoundException {
        BookDetail bookDetailDb = bookService.removeBookDetail(bookId);
        return BookDetailDto.fromEntity(bookDetailDb);
    }
}
