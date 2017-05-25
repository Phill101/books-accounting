package ru.phill.booksAccounting.mvc.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ru.phill.booksAccounting.mvc.bean.Book;
import ru.phill.booksAccounting.mvc.bean.User;
import ru.phill.booksAccounting.mvc.dao.BookDAO;
import ru.phill.booksAccounting.mvc.service.BookService;

import java.util.List;

@Transactional
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public void addBook(Book b) {
        bookDAO.addBook(b);

    }

    @Override
    public boolean userGetBook(User user, int bookId) {
        Book b = bookDAO.findBookById(bookId);
        if (b.getUsers().size() < b.getLibQuantity()) {
            bookDAO.userGetBook(user, b);
            return true;
        }
        return false;
    }

    @Override
    public void userReturnBook(User user, int bookId) {
        Book book = bookDAO.findBookById(bookId);
        bookDAO.userReturnBook(user, book);
    }

    @Override
    public List<Book> findBooksByCategory(User user, Integer categoryId) {
        List<Book> books = bookDAO.findBooksByCategory(categoryId);

        for (Book b : books) {
            if (user.getBooks().contains(b)) {
                b.setEnabled(false);
            }
            b.setAvailable(b.getLibQuantity() - b.getUsers().size());
        }
        return books;
    }

    @Override
    public List<Book> findBooksByNameAndAuthor(String name, String author) {
        return bookDAO.findBooksByNameAndAuthor(name, author);
    }
}
