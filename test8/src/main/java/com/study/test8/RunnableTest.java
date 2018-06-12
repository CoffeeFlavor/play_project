package com.study.test8;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.WeakHashMap;

/**
 * @author : jennie
 * @date: 2018/4/19
 * @Time: 17:51
 */
public class RunnableTest {

    public static void repeatMessage(final String text,final int count ){

        Path firth= Paths.get("/usr/bin");

        Comparable<String> comparable=(firth,second)->Integer.compare(firth.length(),second.length())
    }

    public static void main(String[] args) {
        repeatMessage("hello",1000);
    }
}
