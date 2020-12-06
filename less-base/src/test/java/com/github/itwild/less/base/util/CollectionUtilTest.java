package com.github.itwild.less.base.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollectionUtilTest {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    private static class Hero {

        private Long id;

        private String name;
    }

    /**
     * 使用hutool可方便地给map赋初始值
     */
    @Test
    public void t1() {
        Map<Long, Map<String, Double>> map = MapUtil.builder(new TreeMap<Long, Map<String, Double>>())
                .put(3L, MapUtil.builder(new LinkedHashMap<String, Double>())
                        .put("none", 10.0)
                        .put("A-31", 11.1)
                        .put("xyz", 12.2)
                        .build())
                .put(1L, MapUtil.builder(new LinkedHashMap<String, Double>())
                        .put("none", 20.0)
                        .put("N-618", 21.1)
                        .put("s-003", 22.2)
                        .put("O-L-00004570", 23.3)
                        .put("h-001", 24.4)
                        .build())
                .put(2L, MapUtil.builder(new LinkedHashMap<String, Double>())
                        .put("0.0.0.0", 30.0)
                        .put("192.168.1.101", 31.1)
                        .put("192.168.1.106", 32.2)
                        .put("192.168.1.102", 33.3)
                        .put("192.168.1.109", 34.4)
                        .build())
                .build();

        System.out.println(map);

        assertTrue(map instanceof TreeMap);
        assertEquals(3, map.size());

        Map<String, Double> map2 = map.get(1L);

        assertTrue(map2 instanceof LinkedHashMap);
        assertEquals(5, map2.size());
        assertEquals(21.1, map2.get("N-618"));
    }

    /**
     * List转为Map，这样的需求还是蛮常见的
     */
    @Test
    public void t2() {
        List<Hero> list = CollUtil.toList(
                new Hero(1L, "李寻欢"),
                new Hero(2L, "令狐冲"),
                new Hero(3L, "花无缺")
        );
        // key为Hero的id，value为Hero对象
        Map<Long, Hero> map1 = CollUtil.toMap(list, CollUtil.newHashMap(list.size()), Hero::getId);

        // key为Hero的id，value为Hero的name
        Map<Long, String> map2 = CollUtil.toMap(list, CollUtil.newHashMap(list.size()), Hero::getId, Hero::getName);

        System.out.println(map1);
        System.out.println(map2);

        assertEquals(list.size(), map1.size());
        assertEquals(list.size(), map2.size());

        assertEquals("李寻欢", map1.get(1L).getName());
        assertEquals("李寻欢", map2.get(1L));
    }
}
