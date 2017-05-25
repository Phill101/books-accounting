package ru.phill.booksAccounting.mvc.service;

import ru.phill.booksAccounting.mvc.bean.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);
    List<Category> findAllCategory();
    List<Category> findCategoryByName(String name);
}
