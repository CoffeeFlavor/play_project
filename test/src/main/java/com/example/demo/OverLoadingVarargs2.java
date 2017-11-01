package com.example.demo;

/**
 * User: jennie
 * Date: 2017/9/8
 * Time: 15:21
 */
public class OverLoadingVarargs2 {

    static void f(float i,Character ... args){
        System.out.println("first");
    }

    static void f(char c,Character ... args){
        System.out.println("second");
    }

    public static void main(String[] args) {
        f(1,'a');
        f('a','b');
    }

}
