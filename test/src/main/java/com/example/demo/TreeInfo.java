package com.example.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: jennie
 * Date: 2017/9/29
 * Time: 15:45
 */
public  class TreeInfo implements Iterable<File>{

    public List<File> files=new ArrayList<>();

    public List<File> dirs=new ArrayList<>();


    @Override
    public Iterator<File> iterator() {
        return files.iterator();
    }

    void addAll(TreeInfo other){
        files.addAll(other.files);
        dirs.addAll(other.dirs);
    }

    public String toString(){
        return "dirs: "+PPrint.pformat(dirs)+"" +
                "\n\n files: ;"+PPrint.pformat(files);
    }

    public static TreeInfo walk(String start,String regex){
        return recurseDirs(new File(start),regex );
    }

    public static TreeInfo walk(File start,String regex){
        return recurseDirs(start,regex);
    }

    public static TreeInfo walk(String start){
        return recurseDirs(new File(start),".*" );
    }


    static TreeInfo recurseDirs(File startDir,String regex){
        TreeInfo result=new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                result.dirs.add(item);
            }else {
                if (item.getName().matches(regex)){
                    result.files.add(item);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        if (args.length==0){
            System.out.println(walk("."));
        }else {
            for (String arg : args) {
                System.out.println(walk(arg));
            }
        }
    }
}
