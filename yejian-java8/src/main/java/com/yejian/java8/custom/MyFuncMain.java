package com.yejian.java8.custom;

/**
 * @Name: MyFuncMain
 * @Description: 测试自定义的函数式接口
 * @Version: V1.0.0
 * @Author: yejian
 * @CreateDate: 2022-09-05
 */
public class MyFuncMain  {

    public static void main(String[] args) {
        System.out.println(handleString((e)->e.toUpperCase(),"abc"));
    }

    public static String handleString(MyFunc<String> myFunc,String str) {
        return myFunc.getValue(str);
    }
}
