package com.betrybe.alexandria.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private BookDetail detail;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Book() {
    }

    public Book(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public BookDetail getDetail() {
        return detail;
    }

    public void setDetail(BookDetail detail) {
        this.detail = detail;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
