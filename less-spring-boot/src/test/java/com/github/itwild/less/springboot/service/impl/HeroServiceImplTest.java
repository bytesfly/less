package com.github.itwild.less.springboot.service.impl;

import com.alibaba.testable.core.annotation.MockMethod;
import com.github.itwild.less.base.http.feign.WeatherExample;
import com.github.itwild.less.springboot.BaseTest;
import com.github.itwild.less.springboot.service.HeroService;

import com.github.itwild.less.springboot.service.client.WeatherClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class HeroServiceImplTest extends BaseTest {

    @Autowired
    private HeroService heroService;

    //@MockMethod(targetClass = WeatherClient.class, targetMethod = "query")
    @MockMethod
    private WeatherExample.Response query(WeatherClient self, String cityCode) {
        if ("1024".equals(cityCode)) {
            WeatherExample.Response response = new WeatherExample.Response();
            response.setCityInfo(new WeatherExample.CityInfo().setCity("mock城市"));
            response.setData(new WeatherExample.Data().setYesterday(
                    new WeatherExample.Forecast().setNotice("this is from mock")));
            return response;
        }
        return self.query(cityCode);
    }

    @Test
    public void storyTest() {
        String story = heroService.story(1L, "1024");
        System.out.println(story);
    }
}
