package com.github.itwild.less.core.http;

import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 查询城市天气预报的例子
 * <p>
 * 上海天气预报 http://t.weather.itboy.net/api/weather/city/101020100
 * 合肥天气预报 http://t.weather.itboy.net/api/weather/city/101220101
 * <p>
 * 更多城市 https://github.com/baichengzhou/weather.api/blob/master/src/main/resources/citycode-2019-08-23.json
 * 注意是找的是city_code，而不是id
 */
public class WeatherExample {

    private static final String API_URL = "http://t.weather.itboy.net";

    private static final String SHANG_HAI = "101020100";
    private static final String HE_FEI = "101220101";

    public interface WeatherApi {

        @RequestLine("GET /api/weather/city/{city_code}")
        Response query(@Param("city_code") String cityCode);
    }

    public static void main(String[] args) {
        WeatherApi weatherApi = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(WeatherApi.class, API_URL);

        Response shangHaiWeacher = weatherApi.query(SHANG_HAI);
        Response heFeiWeacher = weatherApi.query(HE_FEI);

        System.out.println(shangHaiWeacher.getData().getYesterday().getNotice());
        System.out.println(heFeiWeacher.getData().getYesterday().getNotice());
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Response {
        private String message;
        private int status;
        private String date;
        private String time;
        private CityInfo cityInfo;
        private Data data;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class CityInfo {
        private String city;
        private String citykey;
        private String parent;
        private String updateTime;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Data {
        private String shidu;
        private int pm25;
        private int pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private List<Forecast> forecast;
        private Forecast yesterday;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Forecast {
        private String date;
        private String high;
        private String low;
        private String ymd;
        private String week;
        private String sunrise;
        private String sunset;
        private int aqi;
        private String fx;
        private String fl;
        private String type;
        private String notice;
    }
}
