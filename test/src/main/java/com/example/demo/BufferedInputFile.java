package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * User: jennie
 * Date: 2017/10/10
 * Time: 11:49
 */
public class BufferedInputFile {

    public static String  read(String fileName) throws IOException{
        BufferedReader in=new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder sb=new StringBuilder();
        while ((s=in.readLine())!=null){
            sb.append(s+"\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException{
        //你好很好
        StringReader in = new StringReader(BufferedInputFile.read("F:\\play_project\\test\\src\\main\\java\\com\\example\\demo\\BufferedInputFile.java"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char)c);
        }
    }
}
