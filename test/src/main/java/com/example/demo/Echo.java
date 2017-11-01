package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: jennie
 * Date: 2017/10/13
 * Time: 10:40
 */
public class Echo {

    public static void main(String[] args) throws IOException {
        BufferedReader stdin=new BufferedReader(new
                InputStreamReader(System.in));
        String s;
        while ((s = stdin.readLine()) != null&&s.length()!=0) {
            System.out.println(s);
        }
    }
}
