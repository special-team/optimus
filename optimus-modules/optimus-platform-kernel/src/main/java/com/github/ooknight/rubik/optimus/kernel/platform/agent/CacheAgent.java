package com.github.ooknight.rubik.optimus.kernel.platform.agent;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import javax.annotation.Resource;
import java.util.Collection;

@Deprecated
public class CacheAgent {

    @Resource
    private CacheManager cacheManager;

    public void clear() {
        Collection<String> cacheNames = cacheManager.getCacheNames();
        for (String t : cacheNames) {
            Cache cache = cacheManager.getCache(t);
            cache.clear();
        }
    }

    public String info() {
        StringBuilder sb = new StringBuilder();
        Collection<String> cacheNames = cacheManager.getCacheNames();
        for (String t : cacheNames) {
            Cache cache = cacheManager.getCache(t);
            sb.append(t).append(":").append(cache.getNativeCache().toString()).append(", ");
        }
        return sb.toString();
    }
}
