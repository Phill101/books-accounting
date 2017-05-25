package ru.phill.booksAccounting.mvc.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.phill.booksAccounting.mvc.bean.Book;
import ru.phill.booksAccounting.mvc.bean.User;
import ru.phill.booksAccounting.mvc.dao.BookDAO;

import java.util.List;

public class BookDAOImpl implements BookDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addBook(Book b) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(b);
    }

    @Override
    public Book findBookById(int bookId) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Book.class, bookId);
    }

    @Override
    public void userGetBook(User user, Book book) {
        Session session = sessionFactory.getCurrentSession();
        boolean result = user.getBooks().add(book);
        if (result) {
            session.update(user);
        }
    }

    @Override
    public void userReturnBook(User user, Book book) {
        Session session = sessionFactory.getCurrentSession();
        boolean result = user.getBooks().remove(book);
        if (result) {
            session.update(user);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> findBooksByCategory(Integer categoryId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("from Book b where b.categoryByCategoryId.id = :categoryParam");
        query.setParameter("categoryParam", categoryId);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> findBooksByNameAndAuthor(String name, String author) {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("from Book b where b.name = :nameParam and b.author = :authorParam");
        query.setParameter("nameParam", name);
        query.setParameter("authorParam", author);
        return query.getResultList();
    }

}
