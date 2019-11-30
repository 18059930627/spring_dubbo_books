package com.qf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.entity.Student;

import java.util.List;

/**
 * @Author chenzhongjun
 * @Date 2019/11/30
 */
public interface StudentMapper extends BaseMapper<Student> {
    List<Integer> getBooksIdById(Integer id);

}
