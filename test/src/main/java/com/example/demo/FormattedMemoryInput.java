package com.example.demo;


import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * User: jennie
 * Date: 2017/10/10
 * Time: 14:07
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        //你好,很好很出色就是很出色,不知道认不认同
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("F:\\play_project\\test\\src\\main\\java\\com\\example\\demo\\FormattedMemoryInput.java").getBytes()));
        StringBuffer sb=new StringBuffer();
        int len=0;
        byte[] buffer=new  byte[48];
        while ((len=in.read(buffer))!=-1)
            sb.append(new String(buffer,0,len,"utf-8"));
        System.out.println(sb.toString());
    }
}
