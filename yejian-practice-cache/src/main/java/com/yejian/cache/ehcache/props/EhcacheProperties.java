package com.yejian.cache.ehcache.props;

import java.util.Set;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Name: EhcacheProperties
 * @Description: ehcache属性配置
 * @Version: V1.0.0
 * @Author: yejian
 * @Create Date: 2022-08-13
 */
@Component
@Data
@ConfigurationProperties(prefix = "ehcache")
public class EhcacheProperties {

    private int heap;

    private int offHeap;

    private int disk;

    private String diskDir;

    private Set<String> cacheNames;



}
