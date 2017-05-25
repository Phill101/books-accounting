package ru.phill.booksAccounting.mvc.util.forms;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import ru.phill.booksAccounting.mvc.util.constraints.EmailFreeConstraint;
import ru.phill.booksAccounting.mvc.util.constraints.FieldEquals;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@FieldEquals(field = "password", equalsTo = "confirmPassword")
public class RegForm {
    @NotNull
    @Length(min = 6, max = 30)
    @Email
    @EmailFreeConstraint
    private String email;

    @NotNull
    @Pattern(regexp = "\\w+", message = "может содержать только латинские символы, цифры или символ подчёркивания")
    @Length(min = 5, max = 30)
    private String password;

    private String confirmPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
