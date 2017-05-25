package ru.phill.booksAccounting.mvc.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.phill.booksAccounting.mvc.bean.User;
import ru.phill.booksAccounting.mvc.dao.UserDAO;

import java.util.Collection;

public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUserByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where login = :loginParam");
        query.setParameter("loginParam", login);
        return query.getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<User> findUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where login = :loginParam");
        query.setParameter("loginParam", email);
        return query.getResultList();
    }
}
