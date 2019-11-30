package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.StudentMapper;
import com.qf.entity.Books;
import com.qf.entity.Student;
import com.qf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenzhongjun
 * @Date 2019/11/30
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

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
            
        }
        //将数据信息设置到对象中
        return null;
    }
}
