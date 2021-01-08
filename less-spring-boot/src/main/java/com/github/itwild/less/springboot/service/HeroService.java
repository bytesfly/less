package com.github.itwild.less.springboot.service;

import com.github.itwild.less.springboot.model.db.Hero;

public interface HeroService extends BaseService<Hero> {

    String story(Long heroId, String cityCode);
}
