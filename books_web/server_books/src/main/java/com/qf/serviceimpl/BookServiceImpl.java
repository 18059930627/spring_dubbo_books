package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.mapper.BookMapper;
import com.qf.entity.Books;
import com.qf.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;



@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Books> implements IBookService {

    @Autowired
    BookMapper bookMapper;

}
