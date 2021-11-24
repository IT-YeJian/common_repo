package com.yj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Name: TestController
 * @Description: 测试几个自定义线程池的类
 * @Version: V1.0.0
 * @Author: yejian
 * @Create Date: 2021-11-24
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/testAsyncConfigurer")
    public void testAsyncConfigurer() {
        for (int i = 0; i < 10; i++) {
            testService.sync();
        }
    }


}
