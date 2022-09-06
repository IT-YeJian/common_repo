package com.yejian.java8.custom;

/**
 * @Name: MyFunc2
 * @Description: 声明一个带两个泛型的函数式接口,泛型类型为<T, R>，其中，T 作为参数的类型，R 作为返 回值的类型
 * @Version: V1.0.0
 * @Author: yejian
 * @Create Date: 2022-09-06
 */
@FunctionalInterface
public interface MyFunc2<T,R> {

    R getValue(T t1,T t2);
}
