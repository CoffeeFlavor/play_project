package com.example.demo;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
 * User: jennie
 * Date: 2017/9/6
 * Time: 16:37
 */
public class StaticSupper {

    public static  String staticGet(){
        return "base staticGet";
    }

    public String dynamicGet(){
        return "base dynamicGet";
    }
}
