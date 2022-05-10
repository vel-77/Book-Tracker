package com.booktracker.service;

import com.booktracker.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    Book insert(Book todo);

    void updateBook(Long id, Book todo);

    void deleteBook(Long todoId);
}
