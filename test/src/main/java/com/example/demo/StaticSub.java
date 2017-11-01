package com.example.demo;

/**
 * User: jennie
 * Date: 2017/9/6
 * Time: 16:38
 */
public class StaticSub extends StaticSupper {

    public static  String staticGet(){
        return "derived staticGet";
    }

    @Override
    public String dynamicGet() {
        return "derived dynamicGet()";
    }
}
