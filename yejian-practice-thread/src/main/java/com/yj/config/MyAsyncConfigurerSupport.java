//package com.yj.config;
//
//
//import java.util.concurrent.Executor;
//import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
//import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
///**
// * @Name: MyAsyncConfigurerSupport
// * @Description: TODO
// * @Version: V1.0.0
// * @Author: yejian
// * @Create Date: 2021-11-24
// */
//@Configuration
//public class MyAsyncConfigurerSupport extends AsyncConfigurerSupport {
//
//
//    @Bean("work-executor-MyAsyncConfigurerSupport")
//    public ThreadPoolTaskExecutor executor(){
//        ThreadPoolTaskExecutor executor =new ThreadPoolTaskExecutor();
//        int corePoolSize=10;
//        executor.setCorePoolSize(corePoolSize);
//        int maxPoolSize=50;
//        executor.setMaxPoolSize(maxPoolSize);
//        int queueCapacity=10;
//        executor.setQueueCapacity(queueCapacity);
//        executor.setRejectedExecutionHandler(new CallerRunsPolicy());
//        String threadNamePrefix="work-executor-MyAsyncConfigurerSupport-";
//        executor.setThreadNamePrefix(threadNamePrefix);
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        //
//        int awaitTerminationSeconds=5;
//        executor.setAwaitTerminationSeconds(awaitTerminationSeconds);
//        executor.initialize();
//        return executor;
//    }
//
//    @Override
//    public Executor getAsyncExecutor(){
//        return executor();
//    }
//
//    @Override
//    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler(){
//        return (ex,method,params)->{
//            System.out.println(String.format("执行异步任务 '%s'",method)+ex);
//        };
//    }
//}
