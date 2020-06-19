package com.github.business.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @date 2020/6/17
 */
public class LRUCache {
    private Map<Object, Object> map;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Object, Object>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;  // 容量大于capacity 时就删除
            }
        };
    }
    public Object get(Object key) {
        return map.getOrDefault(key, null);
    }

    public void put(Object key, Object value) {
        map.put(key, value);
    }
}
