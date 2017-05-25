package ru.phill.booksAccounting.mvc.service;

import ru.phill.booksAccounting.mvc.bean.Book;
import ru.phill.booksAccounting.mvc.bean.User;

import java.util.List;

public interface BookService {
    void addBook(Book b);
    boolean userGetBook(User user, int bookId);
    void userReturnBook(User user, int bookId);
    List<Book> findBooksByCategory(User user, Integer categoryId);
    List<Book> findBooksByNameAndAuthor(String name, String author);
}
