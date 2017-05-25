package ru.phill.booksAccounting.mvc.util.constraints;


import ru.phill.booksAccounting.mvc.util.constraints.impl.CategoryUniqueConstraintValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CategoryUniqueConstraintValidator.class)
public @interface CategoryUniqueConstraint {
    String message() default "категория уже существует";
    Class[] groups() default {};
    Class[] payload() default {};
}
