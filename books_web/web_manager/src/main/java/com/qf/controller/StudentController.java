package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Books;
import com.qf.entity.Student;
import com.qf.service.IBookService;
import com.qf.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author chenzhongjun
 * @Date 2019/11/30
 */
@Controller
@RequestMapping("student")
public class StudentController {

    @Reference
    private IStudentService studentService;

    @Reference
    private IBookService bookService;

    /**
     * 查询学生信息
     * @param map
     * @return
     */
    @RequestMapping("list")
    public String getList(ModelMap map){
        List<Student> studentList = studentService.getStudentList();
        map.put("studentList",studentList);
        return "student";
    }

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public String delete(Integer id){
        studentService.deleteStudentById(id);
        return "redirect:/student/list";
    }

    /**
     * 通过id获取学生信息
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("getStudentById")
    public String getStudentById(Integer id,ModelMap map){
        Student student = studentService.getStudentById(id);
        map.put("student",student);
        return "update_student";
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @RequestMapping("update")
    public String update(Student student){
        studentService.updateStudent(student);
        return "redirect:/student/list";
    }

    /**
     * 通过学生ID找到他所有用的书籍
     * @param id
     * @return
     */
    @RequestMapping("getBooksById")
    public String getBooksById(Integer id,ModelMap map){
        Student student = studentService.getBooksById(id);
        map.put("student",student);
        return "student_books_list";
    }

    /**
     * 通过sid和booksId删除学生拥有的书
     * @param id
     * @param booksId
     * @return
     */
    @RequestMapping("deleteBooksById")
    public String deleteBooksById(Integer id,Integer booksId){
        studentService.deleteBooksById(id,booksId);
        return "redirect:/student/getBooksById?id="+id;
    }

    /**
     * 通过学生ID展示书籍信息添加页面
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("showBooksById")
    public  String addBooksById(Integer id,ModelMap map){
        Student student = studentService.getStudentById(id);
        List<Books> booksList = bookService.list();
        map.put("student",student);
        map.put("booksList",booksList);
        return "student_books_add";
    }

    /**
     * 添加学生书籍信息
     * @param id
     * @param booksId
     * @return
     */
    @RequestMapping("addBooksById")
    public String addBooksById(Integer id,Integer booksId){
        studentService.addBooksById(id,booksId);
        return "redirect:/student/getBooksById?id="+id;
    }

    /**
     * 展示添加页面
     * @return
     */
    @RequestMapping("showAddStudent")
    public String showAddStudent(){
        return "student_add";
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    @RequestMapping("addStudent")
    public String addStudent(Student student){
        studentService.save(student);
        return "redirect:/student/list";
    }

}
