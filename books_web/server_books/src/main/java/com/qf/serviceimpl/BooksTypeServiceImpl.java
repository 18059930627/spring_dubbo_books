package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.entity.BooksType;
import com.qf.mapper.BooksTypeMapper;
import com.qf.service.IBooksTypeService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BooksTypeServiceImpl extends ServiceImpl<BooksTypeMapper,BooksType> implements IBooksTypeService {

    @Autowired
    BooksTypeMapper booksTypeMapper;
}
