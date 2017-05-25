package ru.phill.booksAccounting.mvc.dao;

import ru.phill.booksAccounting.mvc.bean.Book;
import ru.phill.booksAccounting.mvc.bean.User;

import java.util.List;

public interface BookDAO {

    void addBook(Book b);
    Book findBookById(int bookId);
    void userGetBook(User user, Book book);
    void userReturnBook(User user, Book book);
    List<Book> findBooksByCategory(Integer categoryId);
    List<Book> findBooksByNameAndAuthor(String name, String author);
}
