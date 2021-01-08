package com.github.itwild.less.springboot.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.itwild.less.springboot.model.db.Hero;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface HeroMapper extends BaseMapper<Hero> {

}
