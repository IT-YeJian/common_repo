package com.yejian.cache.chm;


import java.util.TimerTask;

/**
 * @Name: CacheCleanTask
 * @Description:
 * 通过定时调度任务TimerTask，来实现控制缓存的有效时间，根据缓存设置的超时时间，来定时清除对应的 key，实现缓存过期
 * 定时任务也可也以用Timer来进行调度，但是Timer与ScheduledExecutorService相比有一些缺陷，
 * @Version: V1.0.0
 * @Author: yejian
 * @Create Date: 2022-07-11
 */
public class CacheCleanTask extends TimerTask {
    private String key;

    private CacheCleanTask(String key){
        this.key = key;
    }

    @Override
    public void run() {
        //移除对应 key
        LocalCache.remove(key);
    }
}
