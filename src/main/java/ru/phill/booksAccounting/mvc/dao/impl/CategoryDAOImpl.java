package ru.phill.booksAccounting.mvc.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.phill.booksAccounting.mvc.bean.Category;
import ru.phill.booksAccounting.mvc.dao.CategoryDAO;

import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(category);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> findAllCategory() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Category").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> findCategoryByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Category c where c.name = :categoryParam").setParameter("categoryParam", name).getResultList();
    }
}
