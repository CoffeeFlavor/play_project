package com.example.demo;

import com.sun.org.apache.regexp.internal.RE;

/**
 * User: jennie
 * Date: 2017/9/6
 * Time: 17:12
 */
public class Composing {

    private Shared shared;

    private static long counter = 0;

    private final long id = counter++;

    public Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    public String toString() {
        return "Composing "+id;
    }

    protected void dispose(){
        System.out.println("disposing "+this);
        shared.dispose();
    }
}
