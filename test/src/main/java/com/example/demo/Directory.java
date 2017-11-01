package com.example.demo;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * User: jennie
 * Date: 2017/9/22
 * Time: 17:13
 */
public final class Directory {

    public static File[] local(File dir,final String regex){
        return dir.listFiles(new FilenameFilter() {
            Pattern pattern=Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
    }

    public static File[] local(String path,final String regex){
        return local(new File(path),regex );
    }



    public static  class TreeInfo implements Iterable<File>{

        public List<File> files=new ArrayList<>();

        public List<File> dirs=new ArrayList<>();


        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(com.example.demo.TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        public String toString(){
            return "dirs: "+PPrint.pformat(dirs)+"" +
                    "\n\n files: ;"+PPrint.pformat(files);
        }

        public static TreeInfo walk(String start, String regex){
            return recurseDirs(new File(start),regex );
        }

        public static TreeInfo walk(File start, String regex){
            return recurseDirs(start,regex);
        }

        public static TreeInfo walk(String start){
            return recurseDirs(new File(start),".*" );
        }


        static TreeInfo recurseDirs(File startDir, String regex){
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

}
