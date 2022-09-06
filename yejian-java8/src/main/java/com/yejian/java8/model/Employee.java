package com.yejian.java8.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Name: Employee
 * @Description: TODO
 * @Version: V1.0.0
 * @Author: yejian
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private String name;
    private Integer age;
    private Double salary;
}
