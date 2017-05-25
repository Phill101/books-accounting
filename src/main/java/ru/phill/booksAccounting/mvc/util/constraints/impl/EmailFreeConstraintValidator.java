package ru.phill.booksAccounting.mvc.util.constraints.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.phill.booksAccounting.mvc.service.UserService;
import ru.phill.booksAccounting.mvc.util.constraints.EmailFreeConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;

@Component
public class EmailFreeConstraintValidator implements ConstraintValidator<EmailFreeConstraint, Object> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(EmailFreeConstraint emailFreeConstraint) {

    }

    @Override
    public boolean isValid(Object target, ConstraintValidatorContext constraintValidatorContext) {
        Collection users = userService.findUserByEmail((String) target);
        return users.size() == 0;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
