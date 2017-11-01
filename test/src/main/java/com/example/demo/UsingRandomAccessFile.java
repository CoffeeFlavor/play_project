package com.example.demo;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * User: jennie
 * Date: 2017/10/10
 * Time: 17:05
 */
public class UsingRandomAccessFile {
    static String file="rtest.dat";
    static void display() throws IOException{
        RandomAccessFile rf=new RandomAccessFile(file,"r");
        for (int i=0;i<7;i++)
            System.out.println("Value "+i+": "+rf.readDouble());
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf=new RandomAccessFile(file,"rw");
        for (int i=0;i<7;i++)
            rf.writeDouble(i*1.414);
        rf.writeUTF("The end of the zho");
        rf.close();
        display();
        rf=new RandomAccessFile(file,"rw");
        rf.seek(5*8);
        rf.writeDouble(47.001);
        rf.close();
        display();
    }
}
