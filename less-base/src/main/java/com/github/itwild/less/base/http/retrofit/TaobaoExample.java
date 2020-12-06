package com.github.itwild.less.base.http.retrofit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 使用retrofit 查询淘宝商品搜索建议的例子
 * <p>
 * 书籍 https://suggest.taobao.com/sug?code=utf-8&q=书籍
 * 衣服 https://suggest.taobao.com/sug?code=utf-8&q=衣服
 * <p>
 * 接口来自 http://www.bejson.com/knownjson/webInterface/
 */
@Slf4j
public class TaobaoExample {

    private static final String API_URL = "https://suggest.taobao.com";

    public interface SuggestApi {

        /**
         * /sug?code=utf-8&q=衣服
         */
        @GET("/sug?code=utf-8")
        Call<Response> query(@Query(value = "q", encoded = true) String keyword);
    }

    public static void main(String[] args) throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        SuggestApi api = retrofit.create(SuggestApi.class);

        Call<Response> bookCall = api.query("书籍");
        Call<Response> clothesCall = api.query("衣服");

        // 异步调用
        bookCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Response r = response.body();
                System.out.println("异步回调：" + r.getResult().stream().map(x -> x.get(0).toString()).collect(Collectors.toList()).toString());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                log.error("clothesCall error", t);
            }
        });

        // 同步调用
        Response clothes = clothesCall.execute().body();
        System.out.println("同步调用：" + clothes.getResult().stream().map(x -> x.get(0).toString()).collect(Collectors.toList()).toString());
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Response {
        private List<List<Object>> result;
    }
}
