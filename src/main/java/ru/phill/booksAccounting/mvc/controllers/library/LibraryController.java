package ru.phill.booksAccounting.mvc.controllers.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.phill.booksAccounting.mvc.bean.User;
import ru.phill.booksAccounting.mvc.service.BookService;
import ru.phill.booksAccounting.mvc.service.CategoryService;
import ru.phill.booksAccounting.mvc.service.UserService;

import java.security.Principal;

@Controller
public class LibraryController {

    private BookService bookService;
    private CategoryService categoryService;
    private UserService userService;

    @Autowired
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    @Qualifier(value = "categoryService")
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/library", method = RequestMethod.GET)
    public ModelAndView ormFindCategory(ModelMap model,
                                        @RequestParam(value = "category", required = false) Integer categoryId,
                                        @RequestParam(value = "getBook", required = false) Integer bookId,
                                        @RequestParam(value = "returnBook", required = false) Integer returnedId,
                                        Principal principal) {
        model.put("categories", categoryService.findAllCategory());

        User user = userService.getUserByLogin(principal.getName());

        if (bookId != null && user.getBooks().size() < 4) {
            bookService.userGetBook(user, bookId);
        }

        if (returnedId != null) {
            bookService.userReturnBook(user, returnedId);
        }

        user = userService.getUserByLogin(principal.getName()); // new user query needs for update his book list
        model.put("userHasBooks", user.getBooks().size());

        if (categoryId != null) {
            model.put("books", bookService.findBooksByCategory(user, categoryId));
            model.put("usersBooks", user.getBooks());
        }

        return new ModelAndView("/library/library", "model", model);
    }
}
