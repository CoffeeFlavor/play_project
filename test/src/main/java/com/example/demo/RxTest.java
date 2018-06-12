package com.example.demo;


import rx.Observable;
import rx.functions.Action1;

/**
 * @author : jennie
 * @date: 2017/12/27
 * @Time: 15:26
 */
public class RxTest {


    public static void main(String[] args) {
        hello("Brandon","Braney","world");
    }


    public static void hello(String ...names){
        Observable.from(names).subscribe(s -> System.out.println("Hello "+s+"!"));
    }
}
