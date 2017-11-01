package com.example.demo;

import java.io.File;
import java.io.IOException;

/**
 * User: jennie
 * Date: 2017/9/30
 * Time: 10:23
 */
public class ProcessFiles {

    public interface Strategy{
     void process(File file);
    }

    private Strategy strategy;

    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args){
        try {
            if (args.length==0){
                processDirctoryTree(new File("'"));
            }else {
                for (String arg : args) {
                    File fileArg=new File(arg);
                    processDirctoryTree(fileArg);
                }
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void processDirctoryTree(File root) throws IOException{
        for (File file : Directory.TreeInfo.walk(root.getAbsolutePath(), ".*\\." + ext)) {
            strategy.process(file.getCanonicalFile());
        }
    }

    public static void main(String[] args) {
        new ProcessFiles(new ProcessFiles.Strategy(){
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        },":java").start(args);
    }
}
