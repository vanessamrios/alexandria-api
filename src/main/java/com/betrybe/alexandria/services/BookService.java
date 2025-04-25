package com.betrybe.alexandria.services;

import com.betrybe.alexandria.entities.Book;
import com.betrybe.alexandria.entities.BookDetail;
import com.betrybe.alexandria.exceptions.BookDetailNotFoundException;
import com.betrybe.alexandria.exceptions.BookNotFoundException;
import com.betrybe.alexandria.repository.BookDetailRepository;
import com.betrybe.alexandria.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookDetailRepository bookDetailRepository;

    @Autowired
    public BookService(BookRepository bookRepository, BookDetailRepository bookDetailRepository) {
        this.bookRepository = bookRepository;
        this.bookDetailRepository = bookDetailRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book findById(Long id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public Book update(Book book, Long id) throws BookNotFoundException {
        Book bookDB = findById(id);

        bookDB.setTitle(book.getTitle());
        bookDB.setGenre(book.getGenre());

        return bookRepository.save(bookDB);
    }

    public Book deleteById(Long id) throws BookNotFoundException {
        Book bookDB = findById(id);
        bookRepository.deleteById(id);
        return bookDB;
    }

    public BookDetail createBookDetail(Long bookId, BookDetail bookDetail) throws BookNotFoundException {
        Book book = findById(bookId);
        bookDetail.setBook(book);
        return bookDetailRepository.save(bookDetail);
    }

    public BookDetail getBookDetail(Long bookId) throws BookNotFoundException {
        Book book = findById(bookId);
        BookDetail bookDetail = book.getDetail();
        if (bookDetail == null) {
            throw new BookDetailNotFoundException();
        }
        return bookDetail;
    }

    public BookDetail updateBookDetail(@PathVariable Long bookid, @RequestBody BookDetail bookDetail)
    throws BookNotFoundException, BookDetailNotFoundException {
        BookDetail bookDetailDB = getBookDetail(bookid);

        bookDetailDB.setSummary(bookDetail.getSummary());
        bookDetailDB.setPageCount(bookDetail.getPageCount());
        bookDetailDB.setYear(bookDetail.getYear());
        bookDetailDB.setIsbn(bookDetail.getIsbn());

        return bookDetailRepository.save(bookDetailDB);
    }

    public  BookDetail removeBookDetail(Long bookId) throws BookNotFoundException, BookDetailNotFoundException {
        Book book = findById(bookId);
        BookDetail bookDetail = book.getDetail();

        if(bookDetail == null) {
            throw new BookDetailNotFoundException();
        }

        book.setDetail(null);
        bookDetail.setBook(null);

        bookDetailRepository.delete(bookDetail);

        return bookDetail;
    }



}
