package com.example.demo;

import com.fasterxml.jackson.core.util.BufferRecycler;
import org.springframework.web.context.request.NativeWebRequest;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * User: jennie
 * Date: 2017/10/11
 * Time: 10:29
 */
public class TextFile extends ArrayList<String> {

    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void write(String fileName,String text){
        try(PrintWriter out=new PrintWriter(new File(fileName).getAbsoluteFile())) {
            out.write(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public TextFile(String fileName,String splitter){
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) remove(0);
    }
    public TextFile(String fileName){
        this(fileName,"\n");
    }
    public void write(String fileName){
        try (PrintWriter out=new PrintWriter(new File(fileName).getAbsoluteFile())){
            for (String item : this) {
                out.println(item);
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file=read("F:\\play_project\\test\\src\\main\\java\\com\\example\\demo\\TextFile.java");
        write("test.txt",file);
        TextFile text=new TextFile("test.txt");
        text.write("text.txt");
        TreeSet<String> worlds=new TreeSet<String>(new TextFile("F:\\play_project\\test\\src\\main\\java\\com\\example\\demo\\TextFile.java","\\W+"));
        System.out.println(worlds.headSet("a"));
    }
}
