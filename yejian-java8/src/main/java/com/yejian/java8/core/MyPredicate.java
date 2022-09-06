package com.yejian.java8.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Name: MyPredicate
 * @Description: TODO
 * @Version: V1.0.0
 * @Author: yejian
 * @CreateDate: 2022-09-06
 */
public class MyPredicate {

    static List<String> filter(List<String> list, Predicate<String> predicate ){
        List<String> strList = new ArrayList<>();
        for (String s : list) {
            if(predicate.test(s)){
                strList.add(s);
            }
        }
        return strList;

    }
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello", "Lambda", "yj", "lyz","yejian");
        System.out.println(filter(list,(s)->s.length()>3));
    }
}
