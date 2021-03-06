package ru.phill.booksAccounting.mvc.dao;

import ru.phill.booksAccounting.mvc.bean.Category;

import java.util.List;

public interface CategoryDAO {
    void addCategory(Category category);
    List<Category> findAllCategory();
    List<Category> findCategoryByName(String name);
}
