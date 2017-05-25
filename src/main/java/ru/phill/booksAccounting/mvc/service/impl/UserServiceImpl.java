package ru.phill.booksAccounting.mvc.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ru.phill.booksAccounting.mvc.bean.User;
import ru.phill.booksAccounting.mvc.dao.UserDAO;
import ru.phill.booksAccounting.mvc.service.UserService;

import java.util.Collection;

@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return userDAO.getUserByLogin(login);
    }

    @Override
    public Collection<User> findUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }

}
