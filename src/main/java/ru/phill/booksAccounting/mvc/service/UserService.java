package ru.phill.booksAccounting.mvc.service;

import ru.phill.booksAccounting.mvc.bean.User;

import java.util.Collection;

public interface UserService {
    void addUser(User user);
    User getUserByLogin(String login);
    Collection<User> findUserByEmail(String email);
}
