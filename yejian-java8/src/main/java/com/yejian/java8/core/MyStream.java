package com.yejian.java8.core;

import com.yejian.java8.model.Employee;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @Name: MyStream
 * @Description:
 * 创建 Stream 一个数据源（如： 集合、数组）， 获取一个流
 * 中间操作 一个中间操作链，对数据源的数据进行处理。
 * 终止操作(终端操作) 一个终止操作，执行中间操作链，并产生结果
 *
 * default Stream stream() : 返回一个顺序流
 * default Stream parallelStream() : 返回一个并行流
 * @Version: V1.0.0
 * @Author: yejian
 * @CreateDate: 2022-09-06
 */
public class MyStream {
    static  List<Employee> list = Arrays.asList(
            new Employee("张三",18,99.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 60, 6666.66),
            new Employee("赵六", 8, 7777.77),
            new Employee("田七", 58, 3333.33)
    );
    static void intArray(){
        int []a={1,2,3};
        IntStream stream = Arrays.stream(a);
    }
    static void longArray(){
        long []a={1,2,3};
        LongStream stream = Arrays.stream(a);
    }
    //等等其他基本类型

    //可以使用静态方法 Stream.of(), 通过显示值创建一个流。它可以接收任意数量的参数。
    static void streamOf(){
        Stream.of(1,2,3);
    }
    //由函数创建流
    static void streamFunc(){
//        Stream.iterate()
//        Stream.generate()
    }

    //中间操作
    //  筛选与切片
    // 1. filter(Predicate p)  接收 Lambda 表达式，从数据流中排除某些元素
    // 2.distinct()  筛选，通过流所生成的 hashCode()和 equals()去除重复的元素
    // 3.limit(long maxSize) 截断流，使其元素不超过给定数量
    // 4.skip(long n) 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个， 则返回一个空流。与 limit()方法互补
    // 映射
    // map(Function f) 接收一个函数作为参数，该函数会被应用到每个元素 上，并将其映射成一个新的元素
    void mapFunc(){
        //将流中每一个元素都映射到 map 的函数中，每个元素执行这个函数，再返回
        List<String> abc = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        abc.stream().map((e) -> e.toUpperCase()).forEach(System.out::printf);
        //获取 Person 中的每一个人得名字 name，再返回一个集合
        List<String> names =list.stream().map(Employee::getName).collect(Collectors.toList());
        //flatMap() 接收一个函数作为参数，将流中的每个值都换成另 一个流，然后把所有流连接成一个流。
    }



    static void toList(){
        list.stream().collect(Collectors.toList());
        long count = list.stream().collect(Collectors.counting());
        int total = list.stream().collect(Collectors.summingInt(Employee::getAge));
        double avg = list.stream().collect(Collectors.averagingInt(Employee::getAge));
        //收集流中 Integer 属性的统计值。例如平均值 最大值
        IntSummaryStatistics iss = list.stream().collect(Collectors.summarizingInt(Employee::getAge));
        //连接流中每个字符串
        String str = list.stream().map(Employee::getName).collect(Collectors.joining());

        //...
    }



}
