package ru.phill.booksAccounting.mvc.controllers.admPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.phill.booksAccounting.mvc.bean.User;
import ru.phill.booksAccounting.mvc.util.forms.AddBookForm;
import ru.phill.booksAccounting.mvc.util.forms.AddCategoryForm;
import ru.phill.booksAccounting.mvc.util.forms.RegForm;
import ru.phill.booksAccounting.mvc.bean.Category;

import ru.phill.booksAccounting.mvc.service.BookService;
import ru.phill.booksAccounting.mvc.bean.Book;
import ru.phill.booksAccounting.mvc.service.CategoryService;
import ru.phill.booksAccounting.mvc.service.UserService;

import javax.validation.Valid;


@Controller
public class AdmPanelController {

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

    @RequestMapping(value = "/admPanel/addBook", method = RequestMethod.GET)
    public ModelAndView addBook(ModelMap model) {
        AddBookForm addBookForm = new AddBookForm();
        model.put("action", "addBook");
        model.put("categories", categoryService.findAllCategory());
        model.put("addBookForm", addBookForm);

        return new ModelAndView("/admPanel/admPanel", "model", model);
    }

    @RequestMapping(value = "/admPanel/addBook", method = RequestMethod.POST)
    public ModelAndView processAddBook(ModelMap model, @Valid AddBookForm addBookForm, BindingResult result) {
        model.put("action", "addBook");
        model.put("categories", categoryService.findAllCategory());
        model.put("addBookForm", addBookForm);
        if (result.hasErrors()) {
            model.put("success", false);
        } else {
            Book newBook = new Book(addBookForm.getBookName(), addBookForm.getBookAuthor(), Integer.parseInt(addBookForm.getQty()), addBookForm.getCategoryId());
            bookService.addBook(newBook);
            model.put("success", true);
        }
        return new ModelAndView("/admPanel/admPanel", "model", model);
    }

    @RequestMapping(value = "/admPanel/addCategory", method = RequestMethod.GET)
    public ModelAndView addCategory(ModelMap model) {
        AddCategoryForm addCategoryForm = new AddCategoryForm();
        model.put("addCategoryForm", addCategoryForm);
        model.put("action", "addCategory");
        return new ModelAndView("/admPanel/admPanel", "model", model);
    }

    @RequestMapping(value = "/admPanel/addCategory", method = RequestMethod.POST)
    public ModelAndView processAddCat(ModelMap model, @Valid AddCategoryForm addCategoryForm, BindingResult result) {
        model.put("addCategoryForm", addCategoryForm);
        model.put("action", "addCategory");
        if (result.hasErrors()) {
            model.put("success", false);
        } else {
            Category newCategory = new Category(addCategoryForm.getCategoryName());
            categoryService.addCategory(newCategory);
            model.put("success", true);
        }
        return new ModelAndView("/admPanel/admPanel", "model", model);
    }

    @RequestMapping(value = "/admPanel/addUser", method = RequestMethod.GET)
    public ModelAndView addUser(ModelMap model) {
        RegForm regForm = new RegForm();
        model.put("regForm", regForm);
        model.put("action", "addUser");
        return new ModelAndView("/admPanel/admPanel", "model", model);
    }

    @RequestMapping(value = "/admPanel/addUser", method = RequestMethod.POST)
    public ModelAndView processReg(ModelMap model, @Valid RegForm regForm, BindingResult result) {
        model.put("regForm", regForm);
        model.put("action", "addUser");
        if (result.hasErrors()) {
            model.put("success", false);
        } else  {
            User newUser = new User(regForm.getEmail(), regForm.getPassword());
            userService.addUser(newUser);
            model.put("success", true);
        }
        return new ModelAndView("/admPanel/admPanel", "model", model);
    }
}
