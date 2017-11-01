package com.example.demo;

/**
 * User: jennie
 * Date: 2017/9/7
 * Time: 11:01
 */
public class Book {
    boolean checkOut=false;

    public Book(boolean checkOut) {
        this.checkOut = checkOut;
    }

    void checkIn(){
        checkOut=false;
    }

    protected void finalize(){
        if (checkOut){
            System.out.println("Error:checked out");
        }
    }
}
