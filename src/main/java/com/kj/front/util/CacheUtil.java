package com.kj.front.util;

import com.kj.comom.util.LoggerUtil;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/7/1 下午5:02
 * @description
 */
@Component
public class CacheUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheUtil.class);

    @Autowired()
    CacheManager ehCacheManager;

    /**
     * 获取Ehcache对象
     * @param cacheName
     * @return
     */
    public Cache getEhcache(String cacheName){
        return ehCacheManager.getCache(cacheName);
    }

    /**
     * 获取缓存
     * @param cacheName
     * @param key
     * @return
     */
    public Object getCacheByKey(String cacheName,String key){

        Cache ehcache = getEhcache(cacheName);
        if (ehcache == null) {
            return null;
        }
        if (ehcache.get(key)!=null) {
            return ehcache.get(key).getObjectValue();
        }
        return null;
    }


    /**
     * 保存缓存--没有则创建一个
     * @param cacheName
     * @param key
     * @param value
     */
    public void putCache(String cacheName,String key,Object value){
        Cache cache = ehCacheManager.getCache(cacheName);
        if(cache==null){
            LoggerUtil.info(LOGGER,"cache is null...");
            ehCacheManager.addCache(cacheName);
            cache = ehCacheManager.getCache(cacheName);
            cache.put(new Element(key,value));
        }
        cache.put(new Element(key,value));
    }

    /**
     * 删除缓存
     * @param cacheName
     * @param key
     */
    public void removeCache(String cacheName,String key){
        Cache cache = ehCacheManager.getCache(cacheName);
        if (cache == null) {
            LoggerUtil.info(LOGGER,"cache is null...");
            return;
        }
        ehCacheManager.removeCache(key);

    }


    /**
     * 更新缓存
     * @param cacheName
     * @param key
     * @param value
     */
    public void updateCache(String cacheName,String key,Object value){
        Cache cache = ehCacheManager.getCache(cacheName);
        if (cache != null) {
            cache.replace(new Element(key,value));
        }
    }

    /**
     * 关闭缓存
     */
    public void shutDownCache(){
        ehCacheManager.shutdown();
    }


    public CacheManager getEhCacheManager() {
        return ehCacheManager;
    }

    public void setEhCacheManager(CacheManager ehCacheManager) {
        this.ehCacheManager = ehCacheManager;
    }
}
