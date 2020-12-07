package com.github.itwild.less.alibaba.testable.example1;

import com.alibaba.testable.core.accessor.PrivateAccessor;
import com.alibaba.testable.core.annotation.TestableMock;
import com.alibaba.testable.processor.annotation.EnablePrivateAccess;
import com.github.itwild.less.base.http.feign.WeatherExample;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@EnablePrivateAccess
public class CityWeatherTest {

    @TestableMock(targetMethod = "query")
    public WeatherExample.Response query(WeatherApi self, String cityCode) {
        WeatherExample.Response response = new WeatherExample.Response();
        // mock天气接口调用返回的结果
        response.setCityInfo(new WeatherExample.CityInfo().setCity(
                CityWeather.CITY_CODE.getOrDefault(cityCode, cityCode)));
        response.setData(new WeatherExample.Data().setYesterday(
                new WeatherExample.Forecast().setNotice("this is from mock")));
        return response;
    }

    CityWeather cityWeather = new CityWeather();

    /**
     * 测试 public方法调用
     */
    @Test
    public void test_public() {
        String shanghai = cityWeather.queryShangHaiWeather();

        System.out.println(shanghai);
        assertEquals("上海市: this is from mock", shanghai);
    }

    /**
     * 测试 private方法调用
     */
    @Test
    public void test_private() {
        String hefei = (String) PrivateAccessor.invoke(cityWeather, "queryHeFeiWeather");

        System.out.println(hefei);
        assertEquals("合肥市: this is from mock", hefei);
    }

    /**
     * 测试 静态方法调用
     */
    @Test
    public void test_static() {
        String beijing = CityWeather.queryBeiJingWeather();

        System.out.println(beijing);
        assertEquals("北京市: this is from mock", beijing);
    }
}
