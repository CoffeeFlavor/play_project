package com.example.demo;

import java.io.*;

/**
 * User: jennie
 * Date: 2017/10/10
 * Time: 15:25
 */
public class BasicFileOutput {
    static String file = "F:\\play_project\\test\\src\\main\\java\\com\\example\\demo\\BasicFileOutput.out";

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("F:\\play_project\\test\\src\\main\\java\\com\\example\\demo\\BasicFileOutput.java")));
            PrintWriter out = new PrintWriter(file);
            int lineCount = 1;
            String s;
            while ((s = in.readLine()) != null)
                out.println(lineCount++ + ": " + s);
            out.close();
            System.out.println(BufferedInputFile.read(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
