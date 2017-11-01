package com.example.demo;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * User: jennie
 * Date: 2017/9/22
 * Time: 10:32
 */
public class DirList {

    public static FilenameFilter filter(final String regex){
        return new FilenameFilter() {
            private Pattern pattern=Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(final String[] args) {
        File path=new File(".");
        String[] list;
        if (args.length==0){
            list=path.list();
        }else {
            list=path.list(new FilenameFilter() {
                private Pattern pattern=Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
        System.out.println(path.getAbsolutePath());
    }
}
