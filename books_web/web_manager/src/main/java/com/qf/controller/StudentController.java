package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Student;
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
}
