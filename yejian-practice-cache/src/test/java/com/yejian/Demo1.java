package com.yejian;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.ExpiryPolicy;
import org.junit.Test;

/**
 * @Name: Demo1
 * @Description: 简单的ehcache
 * @Version: V1.0.0
 * @Author: yejian
 * @Create Date: 2022-08-06
 */
public class Demo1 {


    @Test
    public void test(){

        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                //管理多个cache
                .withCache("students", CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class,String.class,
                        //设置存储在堆内存中的 实例个数 或者大小
                        ResourcePoolsBuilder.newResourcePoolsBuilder()
                                //多种组合方式
                                /**
                                 *  heap + off-heap
                                 *  heap + disk（常用）
                                 *  heap + off-heap+ disk
                                 *
                                 *  设置大小
                                 *  heap < off-heap<disk
                                 */
                                .heap(10)
//                                .disk(50, MemoryUnit.MB,true)
                                .build())
                                .withExpiry(ExpiryPolicy.NO_EXPIRY)//不设置过期时间
                                //设置2天 存储时间
                              //  .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofDays(2)))
                                //设置2天 生存时间 每次获取数据后重置时间
                               // .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofDays(2)))

                        .build())//.with(CacheManagerBuilder.persistence("/var/ehcache"))设置实例保存路径 支持path和File

                .build();

        cacheManager.init();

        Cache<String, String> item = cacheManager.getCache("students", String.class, String.class);

        item.put("yejian","hello world");
        String yejian = item.get("yejian");
        System.out.println(yejian);
        //注: 这个需配置close 保证jvm重启后依旧可以读取到数据
        cacheManager.close();
    }
}
