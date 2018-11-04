package com.wzh.mybatis_base.localcache;

import java.util.List;

public class ItemCacheConfig {
    String tableCacheName;
    List<CacheIndex> cacheTypeList;
    String sql;

    public ItemCacheConfig(String tableCacheName, List<CacheIndex> cacheTypeList, String sql) {
        this.tableCacheName = tableCacheName;
        this.cacheTypeList = cacheTypeList;
        this.sql = sql;
    }

    public String getTableCacheName() {
        return tableCacheName;
    }

    public void setTableCacheName(String tableCacheName) {
        this.tableCacheName = tableCacheName;
    }

    public List<CacheIndex> getCacheTypeList() {
        return cacheTypeList;
    }

    public void setCacheTypeList(List<CacheIndex> cacheTypeList) {
        this.cacheTypeList = cacheTypeList;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
