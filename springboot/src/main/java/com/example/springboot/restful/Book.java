package com.example.springboot.restful;

public class Book {
    private Long bookId;
    private String title;
    private String author;

    public Book() {
    }

    public Book(Long bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        return title.hashCode() | author.hashCode() & bookId.hashCode();

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Book) || obj.hashCode() != hashCode()) {
            return false;
        }
        Book book = (Book) obj;
            if (book.getBookId() == this.bookId && book.getTitle().equals(this.title) && book.getAuthor().equals(this.author) ) {
                return true;
        }
        return false;
    }
}