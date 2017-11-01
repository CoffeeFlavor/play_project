package com.example.demo;

import java.io.PrintWriter;

/**
 * User: jennie
 * Date: 2017/10/13
 * Time: 10:48
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out=new PrintWriter(System.out,true);
        out.println("hello world");
    }
}
