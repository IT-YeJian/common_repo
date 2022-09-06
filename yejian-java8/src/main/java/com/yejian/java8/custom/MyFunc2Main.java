package com.yejian.java8.custom;

/**
 * @Name: MyFunc2Main
 * @Description: TODO
 * @Version: V1.0.0
 * @Author: yejian
 * @CreateDate: 2022-09-06
 */
public class MyFunc2Main {

    public static void main(String[] args) {
        sum(1,2,(x,y)->x+y);
    }

    static void sum(long s1,long s2,MyFunc2<Long,Long> myFunc2){
        System.out.println(myFunc2.getValue(s1,s2));
    }
}
