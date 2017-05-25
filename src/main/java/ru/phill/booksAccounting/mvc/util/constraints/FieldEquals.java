package ru.phill.booksAccounting.mvc.util.constraints;

import ru.phill.booksAccounting.mvc.util.constraints.impl.FieldEqualsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = FieldEqualsValidator.class)
public @interface FieldEquals {
    public static final String MESSAGE = "пароли должны совпадать";

    String message() default MESSAGE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        FieldEquals[] value();
    }

    String field();

    String equalsTo();
}
