package com.yejian.java8.core;

import java.util.function.Function;

/**
 * @Name: MyFunction
 * @Description: TODO
 * @Version: V1.0.0
 * @Author: yejian
 * @CreateDate: 2022-09-06
 */
public class MyFunction {

    public static void main(String[] args) {
        System.out.println(handleString("abc",(param1)->param1.toUpperCase()));
    }

    static String handleString(String s, Function<String,String> function){
        return function.apply(s);
    }
}
