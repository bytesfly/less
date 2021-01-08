package com.github.itwild.less.springboot.service.impl;

import com.github.itwild.less.springboot.model.db.Book;
import com.github.itwild.less.springboot.service.BaseServiceImpl;
import com.github.itwild.less.springboot.service.BookService;
import com.github.itwild.less.springboot.service.mapper.BookMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookServiceImpl
        extends BaseServiceImpl<BookMapper, Book>
        implements BookService {

    @Autowired
    private BookMapper bookMapper;

}
