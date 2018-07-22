package com.jd.excalibur.common;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class CateCache {

    private CateCache (){}

    private volatile static CateCache instance; //声明成 volatile

    private Cache<String, String> cateCache = CacheBuilder.newBuilder()
            .initialCapacity(16)
            .expireAfterWrite(8, TimeUnit.HOURS)
            .softValues()
            .build();

    public static CateCache getSingleton() {
        if (instance == null) {
            synchronized (CateCache.class) {
                if (instance == null) {
                    instance = new CateCache();
                }
            }
        }
        return instance;
    }

    public synchronized Cache<String, String> getCateCache(){
        return cateCache;
    }
}
