package com.qf.controller;

import com.qf.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    IBookService bookService;

    @RequestMapping("list")
    public String getBookList(Model model){
        List<Book> bookList = bookService.list();
        model.addAttribute("bookList",bookList);
        return "book_list";
    }

}
