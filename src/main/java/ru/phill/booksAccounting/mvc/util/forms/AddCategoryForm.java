package ru.phill.booksAccounting.mvc.util.forms;

import org.hibernate.validator.constraints.Length;
import ru.phill.booksAccounting.mvc.util.constraints.CategoryUniqueConstraint;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AddCategoryForm {

    @NotNull
    @Length(min = 1, max = 30)
    @Pattern(regexp = "(^[a-zA-Zа-яА-Я0-9_.',!: ]*$)", message = "содержит недопустимые символы")
    @CategoryUniqueConstraint
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
