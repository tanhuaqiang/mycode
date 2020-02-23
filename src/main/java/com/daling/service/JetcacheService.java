package com.daling.service;

import com.alicp.jetcache.anno.*;

public interface JetcacheService {


    /**
     * 在方法上增加@Cache，即可在对应方法上增加缓存
     * @CacheRefresh 单位默认是秒，配置1分钟刷新一次
     * @param message
     * @return
     */
    @Cached(cacheType = CacheType.LOCAL)
    @CacheRefresh(refresh = 60)
    public Integer printSay(String message);


    /**
     * 缓存失效
     * 表示从缓存名称为c1，将对应key为id值的记录从缓存c1中删除
     * @param id
     */
    @CacheInvalidate(name = "c1", key = "args[0]")
    public void delete(String id);


    /**
     * 刷新缓存对应的缓存名称为c1，缓存中对应的key为id的值，更新key的值为value的值
     * @param id
     * @param value
     */
    @CacheUpdate(name = "c1", key = "#id", value = "args[1]")
    void update(String id, int value);



}
