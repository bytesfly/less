package com.github.itwild.less.alibaba.testable.example1;

import cn.hutool.core.map.MapUtil;
import com.github.itwild.less.base.http.feign.WeatherExample;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import java.util.HashMap;
import java.util.Map;

public class CityWeather {

    private static final String API_URL = "http://t.weather.itboy.net";

    private static final String BEI_JING = "101010100";
    private static final String SHANG_HAI = "101020100";
    private static final String HE_FEI = "101220101";

    public static final Map<String, String> CITY_CODE = MapUtil.builder(new HashMap<String, String>())
            .put(BEI_JING, "北京市")
            .put(SHANG_HAI, "上海市")
            .put(HE_FEI, "合肥市")
            .build();

    private static WeatherApi weatherApi = Feign.builder()
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .target(WeatherApi.class, API_URL);

    public String queryShangHaiWeather() {
        WeatherExample.Response response = weatherApi.query(SHANG_HAI);
        return response.getCityInfo().getCity() + ": " + response.getData().getYesterday().getNotice();
    }

    private String queryHeFeiWeather() {
        WeatherExample.Response response = weatherApi.query(HE_FEI);
        return response.getCityInfo().getCity() + ": " + response.getData().getYesterday().getNotice();
    }

    public static String queryBeiJingWeather() {
        WeatherExample.Response response = weatherApi.query(BEI_JING);
        return response.getCityInfo().getCity() + ": " + response.getData().getYesterday().getNotice();
    }

    public static void main(String[] args) {
        CityWeather cityWeather = new CityWeather();

        String shanghai = cityWeather.queryShangHaiWeather();
        String hefei = cityWeather.queryHeFeiWeather();
        String beijing = CityWeather.queryBeiJingWeather();

        System.out.println(shanghai);
        System.out.println(hefei);
        System.out.println(beijing);
    }
}
