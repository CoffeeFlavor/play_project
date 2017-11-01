package com.example.demo;

import java.io.*;

/**
 * User: jennie
 * Date: 2017/10/11
 * Time: 17:01
 */
public class BinaryFile {

    public static byte[] read(File bfile) throws IOException{
       try(BufferedInputStream bf=new BufferedInputStream(new FileInputStream(bfile))) {
            byte[] data=new byte[bf.available()];
            bf.read(data);
            return data;
       }
    }

    public static byte[] read(String bfile) throws IOException{
        return read(new File(bfile));
    }
}
