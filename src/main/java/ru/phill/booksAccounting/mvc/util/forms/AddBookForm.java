package ru.phill.booksAccounting.mvc.util.forms;

import org.hibernate.validator.constraints.Length;
import ru.phill.booksAccounting.mvc.util.constraints.UniqueBook;

import javax.validation.constraints.*;

@UniqueBook(bookName = "bookName", bookAuthor = "bookAuthor")
public class AddBookForm {

    @NotNull
    @Length(min = 1, max = 255)
    @Pattern(regexp = "(^[a-zA-Zа-яА-Я0-9_.',!: ]*$)", message = "содержит недопустимые символы")
    private String bookName;

    @NotNull
    @Length(min = 1, max = 255)
    @Pattern(regexp = "(^[a-zA-Zа-яА-Я0-9_.',!: ]*$)", message = "содержит недопустимые символы")
    private String bookAuthor;

    @NotNull()
    @Min(value = 1)
    @Max(value = 2147483647)
    @Pattern(regexp = "\\d+", message = "должно быть натуральным числом")
    private String qty;

    private int categoryId;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
