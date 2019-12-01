package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.dao.StudentMapper;
import com.qf.entity.Books;
import com.qf.entity.BooksType;
import com.qf.entity.Student;
import com.qf.service.IBookService;
import com.qf.service.IBooksTypeService;
import com.qf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenzhongjun
 * @Date 2019/11/30
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Reference
    private IBookService bookService;

    @Reference
    private IBooksTypeService booksTypeService;

    @Override
    public List<Student> getStudentList() {
        return studentMapper.selectList(null);
    }

    @Override
    public int deleteStudentById(Integer id) {
        return studentMapper.deleteById(id);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.selectById(id);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateById(student);
    }

    @Override
    public Student getBooksById(Integer id) {
        List<Books> booksList = new ArrayList<>();
        //通过学生id获取到学生信息
        Student student = studentMapper.selectById(id);
        //通过学生id找到对应的书本ID
        List<Integer> booksIdList = studentMapper.getBooksIdById(id);
        //通过书本id得到书籍信息
        for (Integer booksId : booksIdList) {
            Books books = bookService.getById(booksId);
            //得到书本ID再通过书本ID的类型ID得到类型集合
            BooksType booksType = booksTypeService.getById(books.getTypeId());
            books.setBooksType(booksType);
            booksList.add(books);
        }
        student.setBooksList(booksList);
        //将数据信息设置到对象中
        return student;
    }

    @Override
    public int deleteBooksById(Integer id, Integer booksId) {
        return studentMapper.deleteBooksById(id,booksId);
    }

    @Override
    public int addBooksById(Integer id, Integer booksId) {
        return studentMapper.addBooksById(id,booksId);
    }

}
