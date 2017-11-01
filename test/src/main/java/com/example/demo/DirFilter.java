package com.example.demo;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * User: jennie
 * Date: 2017/9/22
 * Time: 10:35
 */
public class DirFilter implements FilenameFilter{
    private Pattern pattern;

    public DirFilter(String  regex) {
        this.pattern = Pattern.compile(regex);
    }
    public boolean accept(File dir,String name){
        return pattern.matcher(name).matches();
    }
}
