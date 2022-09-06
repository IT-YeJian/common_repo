package com.yejian.java8.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @Name: MySupplier
 * @Description: Supplier 接口是供给型接口，有返回值
 * @Version: V1.0.0
 * @Author: yejian
 * @CreateDate: 2022-09-06
 */
public class MySupplier {

    public static void main(String[] args) {
        List<Integer> numberList = getNumberList(10, () -> new Random().nextInt(100));
        numberList.stream().forEach(System.out::println);
    }
    static List<Integer> getNumberList(int num, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < num; i++){
            list.add(supplier.get());
        }
        return list;
    }
}
