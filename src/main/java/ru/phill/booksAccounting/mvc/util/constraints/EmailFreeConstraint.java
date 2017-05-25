package ru.phill.booksAccounting.mvc.util.constraints;


import ru.phill.booksAccounting.mvc.util.constraints.impl.EmailFreeConstraintValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailFreeConstraintValidator.class)
public @interface EmailFreeConstraint {
    String message() default "электронная почта занята";
    Class[] groups() default {};
    Class[] payload() default {};
}
