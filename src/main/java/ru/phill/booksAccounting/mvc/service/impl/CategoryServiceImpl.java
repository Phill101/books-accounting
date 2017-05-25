package ru.phill.booksAccounting.mvc.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ru.phill.booksAccounting.mvc.bean.Category;
import ru.phill.booksAccounting.mvc.dao.CategoryDAO;
import ru.phill.booksAccounting.mvc.service.CategoryService;

import java.util.List;

@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO categoryDAO;

    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public void addCategory(Category category) {
        categoryDAO.addCategory(category);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryDAO.findAllCategory();
    }

    @Override
    public List<Category> findCategoryByName(String name) {
        return categoryDAO.findCategoryByName(name);
    }
}
