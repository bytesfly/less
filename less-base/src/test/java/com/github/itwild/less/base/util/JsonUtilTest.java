package com.github.itwild.less.base.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import lombok.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonUtilTest {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Hero {
        private Long id;

        private List<Friend> friends;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    private static class Friend {
        private String name;

        private int age;
    }

    /**
     * 格式化json
     */
    @Test
    public void t1() {
        Map<String, String> map = MapUtil.builder(new LinkedHashMap<String, String>())
                .put("key1", "value1")
                .put("key2", "value2")
                .put("key3", "value3")
                .build();

        String json = JsonUtil.safePrettyEncode(map);

        String expected = "{\n" +
                "  \"key1\" : \"value1\",\n" +
                "  \"key2\" : \"value2\",\n" +
                "  \"key3\" : \"value3\"\n" +
                "}";

        assertEquals(expected, json);
    }

    /**
     * 通过反射的type来decode,因为程序中可能有根据反射拿到的泛型类型来decode的需求
     */
    @Test
    public void t2() throws Exception {
        List<Friend> list = CollUtil.toList(
                new Friend("李寻欢", 22),
                new Friend("令狐冲", 20),
                new Friend("花无缺", 18)
        );
        String json = JsonUtil.encode(list);

        Type type = Hero.class.getDeclaredField("friends").getAnnotatedType().getType();

        List<Friend> decodeList = JsonUtil.decode(json, type);

        assertEquals(list.size(), decodeList.size());
        assertEquals(list.get(0).getName(), decodeList.get(0).getName());
        assertEquals(list.get(0).getAge(), decodeList.get(0).getAge());
    }

    /**
     * Java Bean转为Map
     */
    @Test
    public void t3() throws IOException {
        Friend friend = new Friend("李寻欢", 22);
        Map<String, Object> map = JsonUtil.bean2Map(friend);

        assertEquals("李寻欢", map.get("name"));
        assertEquals(22, map.get("age"));
    }

    /**
     * Map转为Java Bean
     */
    @Test
    public void t4() throws IOException {
        Map<String, Object> map = MapUtil.builder(new HashMap<String, Object>())
                .put("name", "李寻欢")
                .put("age", 22)
                .build();

        Friend friend = JsonUtil.map2Bean(map, Friend.class);

        assertEquals("李寻欢", friend.getName());
        assertEquals(22, friend.getAge());
    }
}
