package com.sinugbangisda.bookhive.controller;
import com.sinugbangisda.bookhive.entity.Book;
import com.sinugbangisda.bookhive.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired private BookService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("listBooks", service.fetchAllBooks());
        return "index";
    }

    @GetMapping("/new")
    public String newBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("action", "/new");
        model.addAttribute("header", "Add Book");
        return "form";
    }

    @PostMapping("/new")
    public String addBook(Book book) {
        service.addBook(book);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateBookForm(@PathVariable("id") Integer id, Model model) {
        Book book = service.findBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("action", "/update/" + id);
        model.addAttribute("header", "Update Book");
        return "form";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") Integer id, Book book) {
       service.updateBook(book, id.longValue());
       return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id) {
        service.deleteBook(id);
        return "redirect:/";
    }
}
