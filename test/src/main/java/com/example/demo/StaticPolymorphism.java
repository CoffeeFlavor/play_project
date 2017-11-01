package com.example.demo;

/**
 * User: jennie
 * Date: 2017/9/6
 * Time: 16:43
 */
public class StaticPolymorphism {

    public static void main(String[] args) {
        StaticSupper sup=new StaticSub();
        System.out.println(sup.dynamicGet());
//        System.out.println(sup.staticGet);
    }
}
