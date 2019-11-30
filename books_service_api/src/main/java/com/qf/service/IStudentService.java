package com.qf.service;

import com.qf.entity.Student;

import java.util.List;

/**
 * @Author chenzhongjun
 * @Date 2019/11/30
 */
public interface IStudentService {
    List<Student> getStudentList();

    int deleteStudentById(Integer id);

    Student getStudentById(Integer id);

    int updateStudent(Student student);

    Student getBooksById(Integer id);
}
