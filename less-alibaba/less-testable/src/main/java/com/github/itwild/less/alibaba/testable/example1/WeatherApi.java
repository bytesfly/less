package com.github.itwild.less.alibaba.testable.example1;

import com.github.itwild.less.base.http.feign.WeatherExample;
import feign.Param;
import feign.RequestLine;

public interface WeatherApi {

    @RequestLine("GET /api/weather/city/{city_code}")
    WeatherExample.Response query(@Param("city_code") String cityCode);
}
