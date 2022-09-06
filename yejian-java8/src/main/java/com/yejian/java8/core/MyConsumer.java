package com.yejian.java8.core;

import java.util.function.Consumer;

/**
 * @Name: MyConsumer
 * @Description: 测试consumer接口 Consumer 接口是消费性接口，无返回值
 * @Version: V1.0.0
 * @Author: yejian
 * @CreateDate: 2022-09-06
 */
public class MyConsumer {

    public static void main(String[] args) {
        handlerConsumer(100,x-> System.out.println(x));
    }
    static void handlerConsumer(Integer number, Consumer<Integer> consumer){
        consumer.accept(number);
    }
}
