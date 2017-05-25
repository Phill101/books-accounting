package ru.phill.booksAccounting.mvc.util.constraints.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.phill.booksAccounting.mvc.service.BookService;
import ru.phill.booksAccounting.mvc.util.constraints.FieldEquals;
import ru.phill.booksAccounting.mvc.util.constraints.UniqueBook;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

public class UniqueBookValidator implements ConstraintValidator<UniqueBook, Object> {

    @Autowired
    private BookService bookService;

    private String bookName;
    private String bookAuthor;
    private String message;

    @Override
    public void initialize(UniqueBook constraintAnnotation) {
        this.message = constraintAnnotation.message();
        this.bookName = constraintAnnotation.bookName();
        this.bookAuthor = constraintAnnotation.bookAuthor();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        final Object name = getProperty(value, bookName, null);
        final Object author = getProperty(value, bookAuthor, null);

        boolean result = bookService.findBooksByNameAndAuthor((String) name, (String) author).size() == 0;

        if (!result) {
            String msg = this.message;
            context.buildConstraintViolationWithTemplate( msg )
                    .addPropertyNode(bookName).addConstraintViolation();
        }
        return result;
    }

    private Object getProperty(Object value, String fieldName,
                               Object defaultValue) {
        Class<?> clazz = value.getClass();
        String methodName = "get" + Character.toUpperCase(fieldName.charAt(0))
                + fieldName.substring(1);
        try {
            Method method = clazz.getDeclaredMethod(methodName, new Class[0]);
            return method.invoke(value);
        } catch (Exception e) {
        }
        return defaultValue;
    }
}
