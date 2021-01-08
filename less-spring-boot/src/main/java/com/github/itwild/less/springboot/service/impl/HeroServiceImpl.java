package com.github.itwild.less.springboot.service.impl;

import com.github.itwild.less.base.http.feign.WeatherExample;
import com.github.itwild.less.springboot.model.db.Hero;
import com.github.itwild.less.springboot.service.BaseServiceImpl;
import com.github.itwild.less.springboot.service.HeroService;
import com.github.itwild.less.springboot.service.client.WeatherClient;
import com.github.itwild.less.springboot.service.mapper.HeroMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HeroServiceImpl
        extends BaseServiceImpl<HeroMapper, Hero>
        implements HeroService {

    @Autowired
    private HeroMapper heroMapper;

    @Autowired
    private WeatherClient weatherClient;

    @Override
    public String story(Long heroId, String cityCode) {
        Hero hero = getById(heroId);
        if (hero == null) {
            return String.format("heroId为%d不存在", heroId);
        }

        WeatherExample.Response weather = weatherClient.query(cityCode);

        StringBuilder sb = new StringBuilder();
        sb.append("人物：").append(hero.getHeroName()).append("\n");
        sb.append("技能：").append(hero.getSkill()).append("\n");
        sb.append("地点：").append(weather.getCityInfo().getCity()).append("\n");
        sb.append("天气：").append(weather.getData().getYesterday().getNotice());

        return sb.toString();
    }
}
