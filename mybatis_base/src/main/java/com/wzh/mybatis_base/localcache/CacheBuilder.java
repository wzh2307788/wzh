package com.wzh.mybatis_base.localcache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheBuilder {
    private static Map<String, Map<String, Object>> cache = new HashMap<>();

    public static void main(String[] args) {
        List<SaCodeNameT> saCodeNameTList = new ArrayList<SaCodeNameT>();
        SaCodeNameT saCodeNameT1 = new SaCodeNameT("Hadoop", "HDFS", "分布式文件系统", "1", "");
        SaCodeNameT saCodeNameT2 = new SaCodeNameT("Hadoop", "MapReduce", "数据处理框架", "1", "Spark");
        SaCodeNameT saCodeNameT3 = new SaCodeNameT("Hadoop", "Spark", "数据处理框架", "1", "MapReduce");
        saCodeNameTList.add(saCodeNameT1);
        saCodeNameTList.add(saCodeNameT2);
        saCodeNameTList.add(saCodeNameT3);

        CacheIndex cacheType = new CacheIndex("codetype,codeflag", List.class);
        List<CacheIndex> cacheTypeList = new ArrayList<CacheIndex>();
        cacheTypeList.add(cacheType);
        ItemCacheConfig tableCacheConfig = new ItemCacheConfig("SaCodeNameT", cacheTypeList, "SELECT *  FROM SA_CODE_NAME_T T");
        List<ItemCacheConfig> tableCacheConfigList = new ArrayList<>();
        tableCacheConfigList.add(tableCacheConfig);
        buildCache(saCodeNameTList, tableCacheConfigList);
    }

    public static void buildCache(List<SaCodeNameT> saCodeNameTList, List<ItemCacheConfig> tableCacheConfigList) {
        for (ItemCacheConfig cacheConfig : tableCacheConfigList) {
            Map<String, Object> tableCache = cache.get(cacheConfig.getTableCacheName());
            if (null != tableCache) {
                List<CacheIndex> cacheTypes = cacheConfig.getCacheTypeList();
                for (CacheIndex cacheType : cacheTypes){
                    Object  tableCacheType=  tableCache.get(cacheType.getCacheKey());
                    if(tableCacheType!=null)return;

                }
            }
        }
    }
/*    public static Object getCacheValue(String tableCacheName){

    }*/

    public static <T> T getCacheValue(String tableCacheName,String cacheType,T t){

        return (T)cache.get(tableCacheName).get(cacheType);
    }

}

