package com.yejian.cache.service;

import com.yejian.cache.ehcache.model.ItemModel;

/**
 * @Name: ItemService
 * @Description: TODO
 * @Version: V1.0.0
 * @Author: yejian
 * @Create Date: 2022-08-13
 */
public interface ItemService {

    String getById(String id,String ...args);


    String save(ItemModel itemModel);

    void clear(String id);

    void clearAll();

    void composible();
}
