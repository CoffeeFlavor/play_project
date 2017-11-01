package com.study.test8;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * User: jennie
 * Date: 2017/8/11
 * Time: 14:06
 */

public class LambdaTest {

    @Test
    public void test() {

        List<String> strings = new ArrayList<String>();
        strings.add("1");
        strings.add("3");
        strings.add("2");
        strings.add("5");
        strings.add("6");
        Stream<String> stream=strings.stream().map(String::new);
        stream.toArray(String[]::new);
        Arrays.sort(strings.toArray(new String[strings.size()]), String::compareToIgnoreCase);
        System.out.println(strings);
    }

    @Test
    public void test1() {
        List<String> strings = new ArrayList<String>();
        strings.add("13");
        strings.add("34qr s");
        strings.add("25");
        strings.add("56arr");
        strings.add("667");
        String[] hs = new String[strings.size()];
        strings.toArray(hs);
        Arrays.sort(strings.toArray(hs),(first, second)->Integer.compare(first.length(),second.length()));
        for (String s : hs) {
            System.out.println(s);
        }
    }
}
