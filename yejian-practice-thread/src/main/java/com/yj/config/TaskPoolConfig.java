package com.yj.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import org.springframework.aop.interceptor.AsyncExecutionAspectSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Name: TaskPoolConfig
 * @Description: 配置自定义的TaskExecutor
 *
 * 由于AsyncConfigurer的默认线程池在源码中为空，
 * Spring通过beanFactory.getBean(TaskExecutor.class)先查看是否有线程池，未配置时，通过beanFactory.getBean(DEFAULT_TASK_EXECUTOR_BEAN_NAME, Executor.class)，
 * 又查询是否存在默认名称为TaskExecutor的线程池。所以可在项目中，定义名称为TaskExecutor的bean生成一个默认线程池。也可不指定线程池的名称，申明一个线程池，本身底层是基于TaskExecutor.class便可。
 * @Version: V1.0.0
 * @Author: yejian
 * @Create Date: 2021-11-24
 */
@Configuration
public class TaskPoolConfig {


//    @Bean(name= AsyncExecutionAspectSupport.DEFAULT_TASK_EXECUTOR_BEAN_NAME)
//    public Executor taskExecutor(){
//        ThreadPoolTaskExecutor executor =new ThreadPoolTaskExecutor();
//        int corePoolSize=10;
//        executor.setCorePoolSize(corePoolSize);
//        int maxPoolSize=50;
//        executor.setMaxPoolSize(maxPoolSize);
//        int queueCapacity=10;
//        executor.setQueueCapacity(queueCapacity);
//        executor.setRejectedExecutionHandler(new CallerRunsPolicy());
//        String threadNamePrefix="work-executor-task-";
//        executor.setThreadNamePrefix(threadNamePrefix);
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        //
//        int awaitTerminationSeconds=5;
//        executor.setAwaitTerminationSeconds(awaitTerminationSeconds);
//        executor.initialize();
//        return executor;
//    }


    //这样的模式，最终底层为TaskExecutor.class，在替换默认的线程池时，可不指定线程池名称
    @Bean(name = "new_task")
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor =new ThreadPoolTaskExecutor();
        int corePoolSize=10;
        executor.setCorePoolSize(corePoolSize);
        int maxPoolSize=50;
        executor.setMaxPoolSize(maxPoolSize);
        int queueCapacity=10;
        executor.setQueueCapacity(queueCapacity);
        executor.setRejectedExecutionHandler(new CallerRunsPolicy());
        String threadNamePrefix="new-work-executor-task-";
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //
        int awaitTerminationSeconds=5;
        executor.setAwaitTerminationSeconds(awaitTerminationSeconds);
        executor.initialize();
        return executor;
    }
}
