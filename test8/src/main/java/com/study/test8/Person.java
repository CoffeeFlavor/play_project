package com.study.test8;

/**
 * @author : jennie
 * @date: 2018/4/25
 * @Time: 10:21
 */
public interface Person {

    long getId();

    default String getName(){
        return "John Q. Public";
    }
}
