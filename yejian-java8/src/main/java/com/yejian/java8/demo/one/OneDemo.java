package com.yejian.java8.demo.one;

import com.yejian.java8.model.Employee;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/**
 * @Name: OneDemo
 * @Description: TODO
 * @Version: V1.0.0
 * @Author: yejian
 */
public class OneDemo {

    public static void main(String[] args) {

        /*******************未使用lamada start**********************************/
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet1 = new TreeSet<>(com1);
        /*******************未使用lamada end**********************************/


        /*******************使用lamada start**********************************/
        Comparator<Integer> com2 = (x,y)-> Integer.compare(x,y);
        TreeSet<Integer> treeSet2 = new TreeSet<>((x,y)-> Integer.compare(x,y));


        List<Employee> emps = Arrays.asList(
                new Employee("张三",18,99.99),
                new Employee("李四", 38, 5555.55),
                new Employee("王五", 60, 6666.66),
                new Employee("赵六", 8, 7777.77),
                new Employee("田七", 58, 3333.33)
        );

        System.out.println("先比较年龄，年龄相同按照姓名比较");
        Collections.sort(emps,(x,y)->{
            if(x.getAge()==y.getAge()){
                return x.getName().compareTo(y.getName());
            }
            return Integer.compare(x.getAge(),y.getAge());
        });
        emps.stream().forEach(System.out::println);


        //遍历集合的方式来查找年龄大于等于 30 的员工信息
        emps.forEach(System.out::println);
        //遍历集合 过滤掉工资大于20的的员工信息
        System.out.println("过滤年龄大于20的的员工信息");
        emps.stream().filter(employee -> employee.getAge()>20.00).forEach(System.out::println);
        System.out.println("过滤年龄大于20的的员工信息 只获取2个员工");
        emps.stream().filter(employee -> employee.getAge()>20).limit(2).forEach(System.out::println);
        System.out.println("获取工资大于100的员工姓名");
        emps.stream().filter(employee -> employee.getSalary()>100.0).map(Employee::getName).forEach(System.out::println);


        System.out.println("匿名内部类转lambda");
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello lambda");
            }
        };
        /*******匿名内部类作为参数传递到 Lambda 表达式作为参数传递****/
        Runnable r2 = ()->{
            System.out.println("hello lambda");
        };

        /*******************lambda语法格式******************/
        /**
         * 1. 语法格式一：无参，无返回值，Lambda 体只有一条语句
         */
        Runnable runnable = ()->{
            System.out.println("hello lambda");
        };
        /**
         * 2. 语法格式二：Lambda 表达式需要一个参数，并且无返回值
         */
        Consumer<String> func1 = (s)->{
            System.out.println(s);
        };
        func1.accept("hello lambda");

        /**
         * 3. 语法格式三：Lambda 只需要一个参数时，参数的小括号可以省略
         */
        Consumer<String> func2 = s -> System.out.println(s);
        func2.accept("Hello Lambda");

        /**
         * 语法格式四：Lambda 需要两个参数，并且有返回值
         */
        BinaryOperator<Integer> bo = (a, b) -> {
            System.out.println("函数式接口"); return a + b;
        };
        System.out.println(bo.apply(1,2));

        /**语法格式五：当 Lambda 体只有一条语句时，return 和大括号可以省略**/
        BinaryOperator<Integer> bo1 = (a, b) -> a + b;
        System.out.println(bo1.apply(2,3));

        /**语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为 JVM 编译器能够通过上下文推断出数据类型，这就是“类型推断”***/
        BinaryOperator<Integer> bo2 = (Integer a, Integer b) -> { return a + b; };
        BinaryOperator<Integer> bo3 = (a, b) ->  a + b; ;
    }

}
