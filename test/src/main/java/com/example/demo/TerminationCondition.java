package com.example.demo;

/**
 * User: jennie
 * Date: 2017/9/7
 * Time: 11:22
 */
public class TerminationCondition {
    public static void main(String[] args) {
        Book novel=new Book(true);
        novel.checkIn();
        new Book(true);
        System.gc();
    }
}
