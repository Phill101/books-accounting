package ru.phill.booksAccounting.mvc.util.constraints;

import ru.phill.booksAccounting.mvc.util.constraints.impl.UniqueBookValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UniqueBookValidator.class)
public @interface UniqueBook {
    String message() default "книга с таким автором и названием уже существует";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        UniqueBook[] value();
    }

    String bookName();

    String bookAuthor();
}
