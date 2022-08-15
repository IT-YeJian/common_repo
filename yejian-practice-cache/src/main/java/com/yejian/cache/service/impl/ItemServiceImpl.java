package com.yejian.cache.service.impl;

import com.yejian.cache.ehcache.model.ItemModel;
import com.yejian.cache.service.ItemService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

/**
 * @Name: ItemServiceImpl
 * @Description: TODO
 * @Version: V1.0.0
 * @Author: yejian
 * @Create Date: 2022-08-13
 */
@CacheConfig(cacheNames = "item",keyGenerator = "cacheItemKeyGenerator")// 指定类上的注解 可以通用标识哪个缓存 不用再每个方法上去指定 缓存实例名称
public class ItemServiceImpl implements ItemService {

//    @Cacheable(cacheNames = {"item"},key = "#id") //key可以自定义的
    @Cacheable(cacheNames = {"item"},keyGenerator = "cacheItemKeyGenerator",sync = true) //key可以自定义的 sync = true可以可控制多个线程排队 让一个请求去获取最新数据 放入缓存 其余线程等待并从缓存获取数据
    @Override
    public String getById(String id,String ...args) { //缓存的key就是方法的参数
        System.out.println("查询DB");//缓存里有数据时候，第二次查询不会执行方法体内的代码
        return id;
    }

    @Override
    @CachePut(cacheNames = {"item"},key = "#itemModel.id") //写数据之后更新缓存 这样下次关联的key 被查询出来的时候返回的就是最新修改的对象
    public String save(ItemModel itemModel) {
        return null;
    }

    @Override
    @CacheEvict(value = "item") //清楚指定参数缓存数据 默认是方法参数作为key
    public void clear(String id) {
        System.out.println("清除缓存成功");
    }

    @Override
    @CacheEvict(value = "item",allEntries = true,beforeInvocation = true) //清楚所有缓存数据 要等到业务代码正常结束之后才回去清楚缓存,可以添加属性beforeInvocation = true 就可以执行方法前清空缓存
    public void clearAll() {
       // int i=1/0;// 存在异常就不会清楚缓存
        System.out.println("清除ALl缓存成功");
    }

    @Caching(evict = {
            @CacheEvict(value = "item",beforeInvocation = true,allEntries = true)
    })
    @Override
    public void composible() {
        System.out.println("组合缓存策略 @Cacheable，@CachePut@CacheEvict三个注解");
    }
}
