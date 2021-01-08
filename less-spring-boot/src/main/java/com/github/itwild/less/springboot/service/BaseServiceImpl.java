package com.github.itwild.less.springboot.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@SuppressWarnings("unchecked")
public class BaseServiceImpl<M extends BaseMapper<T>, T>
        extends ServiceImpl<M, T>
        implements BaseService<T> {

}
