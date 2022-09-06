package com.yejian.java8.dates;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @Name: MyDate
 * @Description:
 * now：静态方法，根据当前时间创建对象
 * of：静态方法，根据指定日期/时间创建对象
 * @Version: V1.0.0
 * @Author: yejian
 * @CreateDate: 2022-09-06
 */
public class MyDate {
    public static void main(String[] args) {
        /**
         * 获得当前系统时间
         */
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);

        // 指定日期时间
        LocalDateTime localDateTime2 = LocalDateTime.of(
                2019, 10, 27, 13, 45,10);
        System.out.println(localDateTime2);

        //时间戳
        Instant instant1 = Instant.now(); // 默认获取 UTC 时区
        System.out.println(instant1);

        // 偏移量运算
        OffsetDateTime offsetDateTime = instant1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        // 获取时间戳
        System.out.println(instant1.toEpochMilli());

        //Duration:用于计算两个“时间”间隔。
        //Period:用于计算两个“日期”间隔 。
    }
}
