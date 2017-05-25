package ru.phill.booksAccounting.mvc.util.constraints.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.phill.booksAccounting.mvc.service.CategoryService;
import ru.phill.booksAccounting.mvc.util.constraints.CategoryUniqueConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryUniqueConstraintValidator implements ConstraintValidator<CategoryUniqueConstraint, Object> {

    @Autowired
    private CategoryService categoryService;

    @Override
    public void initialize(CategoryUniqueConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object target, ConstraintValidatorContext constraintValidatorContext) {
        return categoryService.findCategoryByName((String) target).size() == 0;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
