package com.yj.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Name: TestService
 * @Description: TODO
 * @Version: V1.0.0
 * @Author: yejian
 * @Create Date: 2021-11-24
 */
@Service
public class TestService {

    @Async
    public void sync() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() + "--" + Thread.currentThread().getName());
    }
}
