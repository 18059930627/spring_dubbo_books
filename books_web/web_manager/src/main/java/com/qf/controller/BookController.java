package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Books;
import com.qf.entity.BooksType;
import com.qf.service.IBookService;
import com.qf.service.IBooksTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {

    @Reference
    IBookService bookService;

    @Reference
    IBooksTypeService booksTypeService;


    /**
     * 查询图书集合显示
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String getBookList(Model model){
        List<Books> bookList = bookService.list();

        for (Books books : bookList) {
            Integer typeId = books.getTypeId();
            BooksType booksType = booksTypeService.getById(typeId);
            books.setBooksType(booksType);
        }
        model.addAttribute("bookList",bookList);
        return "book_list";
    }

    /**
     * 删除单个图书
     * @param id
     * @return
     */
    @RequestMapping("delOneBookById")
    public String delOneBookById(Integer id){
        bookService.removeById(id);

        return "redirect:/book/list";
    }

    /**
     * 到添加图书界面
     * @param model
     * @return
     */
    @RequestMapping("toAddOne")
    public String toAddOne(Model model){
        List<BooksType> booksTypeList = booksTypeService.list();
        model.addAttribute("booksTypeList",booksTypeList);
        return "book_add";
    }

    /**
     * 添加一本图书
     * @param book
     * @return
     */
    @RequestMapping("addOneBook")
    public String addOneBook(Books book){
        boolean result = bookService.save(book);

        return "redirect:/book/list";
    }

    /**
     * 修改单个前操作，获得一个实例到界面显示
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("getOneById")
    public String getOneById(Integer id,Model model){

        Books book = bookService.getById(id);
        List<BooksType> booksTypeList = booksTypeService.list();

        model.addAttribute("book",book);
        model.addAttribute("booksTypeList",booksTypeList);

        return "book_update";
    }

    /**
     * 修改一个book对象
     * @param book
     * @return
     */
    @RequestMapping("updateOneBook")
    public String updateOneBook(Books book){
        bookService.updateById(book);
        return "redirect:/book/list";
    }
}
