package com.github.service;

import com.github.business.util.LRUCache;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.function.Function;

/**
 * @date 2020/6/17
 */
@Configuration
public class AppStore implements InitializingBean {

    @Value("${app.store.capacity:1024}")
    private Integer capacity;

    private LRUCache lruCache;

    public AppStore() {

    }

    public void put(Object key, Object value){
        lruCache.put(key, value);
    }

    public Object get(Object key){
        return lruCache.get(key);
    }

    public Object computeIfAbsent(Object key, Function<Object, Object> mappingFunction){
        Objects.requireNonNull(mappingFunction);
        Object v;
        if ((v = get(key)) == null) {
            Object newValue;
            if ((newValue = mappingFunction.apply(key)) != null) {
                put(key, newValue);
                return newValue;
            }
        }
        return v;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        lruCache = new LRUCache(capacity);
    }
}
