package org.library.controller;

import org.library.modal.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class BookController {
     List<Book> bookList = new ArrayList<>(
            Arrays.asList(
                    new Book(1, "Doraemon", "Duong", 10000),
                    new Book(2, "Conan", "Duong", 15000),
                    new Book(3, "Dragon Ball", "Duong", 20000),
                    new Book(4, "Naruto", "Duong", 25000)
            )
    );
    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookList);
        return "bookList";
    }
    @GetMapping("/books/{id}")
    public String bookDetail(@PathVariable("id") int id, Model model) {
        Book foundBook = bookList.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);

        model.addAttribute("selectedBook", foundBook);
        return "bookDetail";
    }
}
