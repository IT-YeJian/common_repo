package com.yejian.java8.custom;

/**
 * @Name: anonations
 * @Description: 自定义函数式接口
 * @Version: V1.0.0
 * @Author: yejian
 * @CreateDate: 2022-09-05
 */
@FunctionalInterface
public interface MyFunc<T> {
    T getValue(T t);



}
