package com.yejian.cache.service.config;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Name: ItemKeyGenerator
 * @Description: TODO
 * @Version: V1.0.0
 * @Author: yejian
 * @Create Date: 2022-08-14
 */

@Configuration
public class ItemKeyGenerator  {

    @Bean(name = "cacheItemKeyGenerator")
    public KeyGenerator itemKeyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName()+ Arrays.asList(params);
            }
        };
    }
}
