package ru.phill.booksAccounting.mvc.dao;

import ru.phill.booksAccounting.mvc.bean.User;

import java.util.Collection;

public interface UserDAO {
    void addUser(User user);
    User getUserByLogin(String login);
    Collection<User> findUserByEmail(String email);
}
