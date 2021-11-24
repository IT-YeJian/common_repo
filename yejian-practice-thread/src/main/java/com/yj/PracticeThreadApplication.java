package com.yj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 重新实现接口AsyncConfigurer
 * 继承AsyncConfigurerSupport
 * 配置由自定义的TaskExecutor替代内置的任务执行器
 */
@EnableAsync
@SpringBootApplication
public class PracticeThreadApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeThreadApplication.class, args);
	}

}
