package com.wzh.mybatis_base.localcache;

public class CacheIndex {
    String  cacheKey;
    Class cacheValueClass;

    public CacheIndex(String cacheKey, Class cacheValueClass) {
        this.cacheKey = cacheKey;
        this.cacheValueClass = cacheValueClass;
    }

    public String getCacheKey() {
        return cacheKey;
    }

    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }

    public Class getCacheValueClass() {
        return cacheValueClass;
    }

    public void setCacheValueClass(Class cacheValueClass) {
        this.cacheValueClass = cacheValueClass;
    }
}
