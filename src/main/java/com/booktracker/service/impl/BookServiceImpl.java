package com.booktracker.service.impl;

import com.booktracker.model.Book;
import com.booktracker.repo.BookRepo;
import com.booktracker.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepository) {
        this.bookRepo = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books;
        books = bookRepo.findAll();
        return books;
    }

    @Override
    public Book insert(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void updateBook(Long id, Book book) {
        Book bookFromDb = bookRepo.findById(id).get();
        System.out.println(bookFromDb.toString());

        bookFromDb.setAuthor(book.getAuthor());
        bookFromDb.setLengthOfBook(book.getLengthOfBook());
        bookFromDb.setTitle(book.getTitle());
        bookFromDb.setYearOfPublication(book.getYearOfPublication());

        bookRepo.save(bookFromDb);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepo.deleteById(bookId);
    }
}
