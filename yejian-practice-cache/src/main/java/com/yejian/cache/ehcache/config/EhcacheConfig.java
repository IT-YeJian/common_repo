package com.yejian.cache.ehcache.config;

import com.yejian.cache.ehcache.model.BaseModel;
import com.yejian.cache.ehcache.props.EhcacheProperties;
import java.util.Set;
import org.ehcache.CacheManager;
import org.ehcache.PersistentCacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.ResourcePools;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.expiry.ExpiryPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Name: EhcacheConfig
 * @Description: TODO
 * @Version: V1.0.0
 * @Author: yejian
 * @Create Date: 2022-08-13
 */
@Configuration
@EnableCaching
public class EhcacheConfig {

    @Autowired
    private EhcacheProperties ehcacheProperties;
    /**
     * 使用3.x的ehcache
     * 不使用springboot自带的ehcache
     * @return
     */
    @Bean
    public CacheManager cacheManager(){
        //1获取缓存实例名称
        Set<String> cacheNames = ehcacheProperties.getCacheNames();

        //2.设置内存存储大小
        ResourcePools resourcePools = ResourcePoolsBuilder.newResourcePoolsBuilder()
                .heap(ehcacheProperties.getHeap())
                .offheap(ehcacheProperties.getOffHeap(), MemoryUnit.MB)
                .disk(ehcacheProperties.getDisk(),MemoryUnit.MB)
                .build();
        //3 设置存储时间
        ExpiryPolicy expiryPolicy = ExpiryPolicyBuilder.noExpiration();

        //4.设置CacheConfiguration
        CacheConfiguration cacheConfiguration =
                CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, BaseModel.class, resourcePools)
                        .withExpiry(expiryPolicy).build();

        //5.构建CacheManagerBuilder
        CacheManagerBuilder<PersistentCacheManager> cacheManagerBuilder = CacheManagerBuilder.newCacheManagerBuilder()
                .with(CacheManagerBuilder.persistence(ehcacheProperties.getDiskDir()));

        cacheNames.forEach(cacheName->{
            cacheManagerBuilder.withCache(cacheName,cacheConfiguration);
        });

        //7 构建
        return cacheManagerBuilder.build();
    }
}
